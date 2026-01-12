public class ServiceProvider {
    private static final String CONSTRUCTOR_NOT_DECLARED = "A constructor with @Inject must be set in service: '%s'";

    private Map<Class<?>, Object> services = new ConcurrentHashMap();

    public <T> T get(Class<T> clazz) {
        Object instance = services.get(clazz);
        if (instance == null) {
            throw new RuntimeException("Service '" + clazz.getSimpleName() + "' not registered");
        }
        return (T) instance;
    }

    public void register(Class<?> clazz) {
        if (!services.containsKey(clazz)) {
            Object instance = createInstance(clazz);
            services.put(clazz, instance);
        }
    }

    private Object createInstance(Class<?> clazz) {
        try {
            Constructor constructor = getConstructor(clazz);
            List<Object> arguments = new ArrayList<>();
            for (Parameter param : constructor.getParameters()) {
                arguments.add(this.get(param.getType())); // Recursion
            }
            IO.println("Creating new instance for: " + clazz);
            Object instance = constructor.newInstance(arguments.toArray());
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Constructor getConstructor(Class<?> clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        return Arrays.stream(constructors)
                .filter(x -> x.isAnnotationPresent(Inject.class))
                .findFirst()
                .or(() -> Arrays.stream(constructors)
                        .filter(x -> x.getParameterCount() == 1)
                        .findFirst()
                )
                .orElseThrow(() -> new RuntimeException(String.format(CONSTRUCTOR_NOT_DECLARED, clazz)));
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface Inject {}

public static class DataBase {
    @Inject
    public DataBase() {}
}

public static class UserRepository {
    private DataBase dataBase;

    @Inject
    public UserRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public UserRepository() {}
}

public static class MetricsRepository {
    private DataBase dataBase;

    @Inject
    public MetricsRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public MetricsRepository() {}
}

public static class UserService {
    private UserRepository userRepository;
    private MetricsRepository metricsRepository;

    @Inject
    public UserService(UserRepository userRepository, MetricsRepository metricsRepository) {
        this.userRepository = userRepository;
        this.metricsRepository = metricsRepository;
    }

    public UserService() {}
}

void main() {
    ServiceProvider provider = new ServiceProvider();

    provider.register(DataBase.class);
    provider.register(UserRepository.class);
    provider.register(MetricsRepository.class);
    provider.register(UserService.class);

    UserService userService = provider.get(UserService.class);
}