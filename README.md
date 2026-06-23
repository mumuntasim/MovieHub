🎬 MovieHub
MovieHub is a web-based movie management application developed with Java and Spring Boot. The platform allows users to browse, create, update, and delete movies, with each movie organized by specific genres.

🚀 Key Features
Authentication System: Secure user registration and login using Spring Security and BCrypt password hashing.

Full CRUD Functionality: Complete lifecycle management for movies (Create, Read, Update, Delete).

Genre Management: Movies are categorized by genres (Action, Comedy, Drama, etc.), which are automatically initialized upon the first startup.

Input Validation: Server-side validation for all forms to ensure data integrity and user feedback.

Modern UI: Responsive design featuring a dark mode with elegant gradient backgrounds.

🛠 Technology Stack
Backend: Java 17, Spring Boot 3.4.0, Spring MVC, Spring Data JPA, Spring Security

Database: MySQL

Frontend: Thymeleaf, Bootstrap 5, HTML5, CSS3

Tools: Maven, Lombok

📂 Domain Entities
User: Application users with role-based access control.

Movie: Entities containing title, description, release date, and an associated genre.

Genre: Predefined categories for efficient movie classification.

📋 Installation & Setup
Clone the repository:

Bash
git clone https://github.com/mumuntasim/moviehub.git
Configure the Database:

Open src/main/resources/application.properties and update your MySQL credentials:

Properties
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

Run the Application:

Execute the MoviehubApplication.java main class. Upon the first startup, the application will automatically generate the database schema and populate the initial list of genres.

Access the App:
Open your browser and navigate to http://localhost:8080.

🛡 Security
Guests: Can browse the movie catalog, register, and log in.

Authenticated Users: Have access to the full CRUD functionality for movie management.

Passwords: Encrypted and stored securely using BCryptPasswordEncoder.
