# Pokémon API - Spring Boot Project

This project is a simple RESTful API built with **Spring Boot** using **Kotlin** that provides information about Pokémon. It allows users to retrieve details about Pokémon from a predefined list (without using a database). The project exposes the following endpoints:

- `/api/pokemon`: A list of all Pokémon.
- `/api/pokemon/{id}`: Details of a specific Pokémon by its ID.

The API can be used for educational purposes or as a starting point for building a Pokémon-related service.

---

## Features

- Built using **Spring Boot 3.4.4** and **Kotlin**.
- Endpoint to list all Pokémon (`/api/pokemon`).
- Endpoint to get a specific Pokémon by ID (`/api/pokemon/{id}`).
- Simple service layer to handle the Pokémon data (stored in a `List`).
- Unit and integration tests using **JUnit 5** and **AssertJ**.

---

## Prerequisites

Before running the project, you need the following tools installed on your local machine:

- **Java 17** (or a higher version supported by Spring Boot).
- **Gradle** (for building and running the project).
- **Git** (for version control).
- **IntelliJ IDEA** (or any other Kotlin-compatible IDE).

---

## How to Set Up and Run the Project

### 1. Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/DanielM3218/pokemom-repo.git
```

### 2. Build the Project

Navigate to the project directory and use **Gradle** to build the project:

```bash
cd /Downloads/pokemonfinal
./gradlew build
```

### 3. Run the Application

Once the build is successful, you can run the application using:

```bash
./gradlew bootRun
```

The Spring Boot application will start, and you can access the API on `http://localhost:8080`.

### 4. Test the Application

You can test the API by sending requests to the endpoints using **Postman**, **cURL**, or your browser.

- **GET** `/api/pokemon`: Returns a list of all Pokémon.
- **GET** `/api/pokemon/{id}`: Replace `{id}` with the Pokémon ID (e.g., `/api/pokemon/1`) to get the details of a specific Pokémon.

Example using **cURL**:
```bash
curl http://localhost:8080/api/pokemon
```

To get the details of a Pokémon with ID `1`:
```bash
curl http://localhost:8080/api/pokemon/1
```

### 5. Running Tests

To run the tests for your project, execute the following command:

```bash
./gradlew test
```

The results will be displayed in the terminal, and you can also view detailed reports at `build/reports/tests/test/index.html`.

---

## Folder Structure

The project follows a standard Spring Boot project structure:

```
src
├── main
│   ├── kotlin
│   │   └── com
│   │       └── example
│   │           └── pokemonfinal
│   │               ├── Controller  # Contains REST endpoints (controllers)
│   │               ├── Model       # Contains the data model (Pokemon)
│   │               └── Service     # Contains the business logic (PokemonService)
├── resources
│   └── application.properties    # Contains application configuration (if needed)
```

---

## Testing

### Unit Tests

The project uses **JUnit 5** and **AssertJ** to run unit and integration tests. These tests check that the controller and service layer behave as expected.

### Example of a Unit Test (Controller)

```kotlin
@WebMvcTest(PokemonController::class)
class PokemonControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var pokemonService: PokemonService

    @Test
    fun `should return list of all pokemons`() {
        val pokemonList = listOf(Pokemon(1, "Bulbasaur", listOf("Grass", "Poison"), 1, "url"))
        Mockito.`when`(pokemonService.getAllPokemons()).thenReturn(pokemonList)

        mockMvc.perform(MockMvcRequestBuilders.get("/api/pokemon")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Bulbasaur"))
    }
}
```

### Running the Tests

To run the tests, you can use:

```bash
./gradlew test
```

The tests will be executed, and you can view the results in the terminal or in the HTML reports under `build/reports/tests/test/index.html`.

---

## Contributing

If you would like to contribute to this project, feel free to fork the repository, make your changes, and create a pull request.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Notes:
- If you wish to deploy the application, you can package it as a **JAR** file and run it on any Java 17 compatible environment.
- This is a simple demonstration of how to work with a Spring Boot application using Kotlin. The data is hardcoded in a list, and no database or persistent storage is used.

---

### Tailoring the README

Feel free to update the repository URL (`https://github.com/DanielM3218/pokemom-repo.git`) with the actual URL of your project and add more detailed setup or customization instructions if needed!
