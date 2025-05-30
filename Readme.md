# OOP-Project

A Java-based client-server application with chat functionality and database integration built using Maven.

## 🚀 Features

- **Client-Server Architecture**: Real-time communication between multiple clients and server
- **Chat Functionality**: Interactive messaging system with real-time updates
- **Database Integration**: Network-hosted database for persistent data storage
- **GUI Interface**: User-friendly graphical interface for client applications
- **Modular Design**: Well-structured Java packages for easy maintenance and scalability

## 📁 Project Structure

```
OOP-Project/
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java           # Java module configuration
│       │   └── org/
│       │       └── example/
│       │           ├── database/          # Database connection and operations
│       │           ├── demo1/             # Demo applications and examples
│       │           └── Manage/            # Management and utility classes
│       └── resources/                     # Application resources
├── target/                                # Compiled classes and build artifacts
├── pom.xml                               # Maven project configuration
├── mvnw                                  # Maven wrapper (Unix)
├── mvnw.cmd                             # Maven wrapper (Windows)
├── ERD.png                              # Entity Relationship Diagram
├── f.puml                               # PlantUML diagram file
├── umlo.puml                           # UML diagram file
└── README.md                           # This file
```

## 🛠️ Technology Stack

- **Language**: Java
- **Build Tool**: Maven
- **Module System**: Java Platform Module System (JPMS)
- **Documentation**: PlantUML for diagrams
- **IDE**: IntelliJ IDEA (configuration included)

## 📋 Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6+ (or use included Maven wrapper)
- Network connection for database functionality
- IntelliJ IDEA (recommended) or any Java IDE

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd OOP-Project
```

### 2. Build the Project
Using Maven wrapper (recommended):
```bash
# On Windows
mvnw.cmd clean compile

# On Unix/Linux/macOS
./mvnw clean compile
```

Or using system Maven:
```bash
mvn clean compile
```

### 3. Run the Application
```bash
# Using Maven wrapper
./mvnw exec:java

# Or using system Maven
mvn exec:java
```

## 📊 Database Setup

This project requires a network-hosted database. Ensure you have:

1. Database server running and accessible
2. Proper connection credentials configured
3. Required database schema and tables created

*Note: Check the `org.example.database` package for database configuration details.*

## 🏗️ Architecture Overview

### Core Components

- **Server Module**: Handles client connections and message routing
- **Client Module**: Provides GUI interface and handles user interactions
- **Database Module**: Manages data persistence and retrieval
- **Management Module**: Utility classes and application management

### Design Patterns Used

- Client-Server Pattern
- MVC (Model-View-Controller)
- Observer Pattern for real-time updates
- Factory Pattern for object creation

## 📈 Development

### Building from Source
```bash
# Clean and compile
./mvnw clean compile

# Run tests (if available)
./mvnw test

# Package the application
./mvnw package
```

### IDE Setup
The project includes IntelliJ IDEA configuration files in the `.idea/` directory for seamless development experience.

## 📋 UML Diagrams

The project includes UML diagrams for better understanding:
- `ERD.png` - Entity Relationship Diagram showing database structure
- `f.puml` - PlantUML source file
- `umlo.puml` - Additional UML diagram source

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is part of an educational Object-Oriented Programming course. Please refer to your institution's guidelines for usage and distribution.

## 🐛 Troubleshooting

### Common Issues

1. **Build Failures**: Ensure JDK version compatibility with `module-info.java`
2. **Database Connection**: Verify network connectivity and database credentials
3. **Port Conflicts**: Check if required ports are available for server functionality

### Getting Help

- Check the `org.example.demo1` package for example implementations
- Review PlantUML diagrams for system architecture understanding
- Ensure all dependencies are properly resolved via Maven

---

*This project demonstrates client-server architecture, real-time communication, and database integration using Java and Maven.*