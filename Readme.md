# BookStay - Hotel Booking Management System

A comprehensive hotel booking and management system built with JavaFX and PostgreSQL, implementing Object-Oriented Programming principles including the Decorator and Factory design patterns.

## 🏨 Overview

BookStay is a desktop application that enables users to search, view, and book accommodations while providing hotel managers with tools to manage their properties. The system features a modern JavaFX interface with real-time chat functionality and comprehensive booking management.

## ✨ Features

### For Customers
- **User Registration & Authentication**: Create accounts with profile photos and personal information
- **Hotel Search & Discovery**: Browse hotels by location, type, and amenities
- **Detailed Hotel Views**: View comprehensive hotel information including images, amenities, and pricing
- **Booking System**: Select dates, calculate costs, and make reservations
- **Real-time Messaging**: Chat with hotel managers directly
- **Profile Management**: View and manage personal information and bookings

### For Hotel Managers
- **Property Management**: Create and manage hotel listings with detailed information
- **Room Configuration**: Add different room types with various amenities using the Decorator pattern
- **Booking Management**: View and manage customer reservations
- **Customer Communication**: Respond to customer inquiries via integrated chat
- **Revenue Tracking**: Monitor booking costs and revenue

### System Features
- **Multi-user Authentication**: Separate interfaces for customers and hotel managers
- **Image Management**: Upload and display multiple hotel images
- **Date Validation**: Prevent double bookings and invalid date selections
- **Cost Calculation**: Automatic pricing based on duration, room type, and amenities
- **Database Integration**: Persistent data storage with PostgreSQL

## 🏗️ Architecture

### Design Patterns Implemented
- **Decorator Pattern**: Used for room amenities (AirConditioner, Balcony, AttachedBath)
- **Factory Pattern**: Hotel type creation (Villa, Cabin, Cottage, AFrames)
- **Strategy Pattern**: Different user types (Customer, HotelManager) with specific behaviors
- **Observer Pattern**: Real-time chat messaging system

### Project Structure
```
src/
├── main/java/
│   ├── org/example/
│   │   ├── demo1/                 # JavaFX Controllers & UI Logic
│   │   │   ├── HelloApplication.java
│   │   │   ├── SignInPageController.java
│   │   │   ├── HomePageForCustomerController.java
│   │   │   ├── HomePageForHotelManagerController.java
│   │   │   ├── hotelClickedController.java
│   │   │   ├── createPostController.java
│   │   │   └── otherClasses/      # Model Classes
│   │   ├── Manage/                # Business Logic & Patterns
│   │   │   ├── Hotel.java         # Abstract Hotel Class
│   │   │   ├── Room.java          # Abstract Room Class
│   │   │   ├── Villa.java, Cabin.java, Cottage.java
│   │   │   ├── AirConditioner.java, Balcony.java
│   │   │   └── CheckInandOut.java # Booking Management
│   │   └── database/              # Data Access Layer
│   │       ├── DatabaseClient.java
│   │       ├── Tables.java
│   │       └── ChatServer.java
│   └── resources/                 # FXML Files & Assets
└── target/                        # Compiled Classes
```

## 🛠️ Technology Stack

- **Frontend**: JavaFX 22 with FXML
- **Backend**: Java 17+
- **Database**: PostgreSQL (Supabase)
- **Build Tool**: Maven
- **UI Styling**: CSS
- **Image Processing**: Base64 encoding/decoding
- **Chat System**: Socket programming

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL database access
- JavaFX SDK (if not using Maven JavaFX plugin)

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd OOP-Project
```

### 2. Database Setup
The application connects to a PostgreSQL database hosted on Supabase. The database includes the following tables:
- `accountinfo` - User accounts and profiles
- `hotels` - Hotel listings and details
- `rooms` - Room configurations and amenities
- `bookings` - Reservation records
- `messages` - Chat communications

### 3. Build and Run
```bash
# Compile the project
mvn clean compile

# Run the application
mvn javafx:run
```

Alternatively, run the main class directly:
```bash
java -cp "target/classes;path/to/javafx/lib/*;path/to/postgresql/driver" org.example.demo1.HelloApplication
```

## 🎯 Usage

### Customer Workflow
1. **Sign Up/Sign In**: Create a new account or log in with existing credentials
2. **Browse Hotels**: Search for hotels by district or browse all available properties
3. **View Details**: Click on any hotel to see detailed information, images, and amenities
4. **Make Booking**: Select check-in/check-out dates, number of guests, and confirm reservation
5. **Chat with Manager**: Use the integrated messaging system to communicate with property owners

### Hotel Manager Workflow
1. **Sign Up as Manager**: Create an account and select "Hotel Manager" account type
2. **Create Listing**: Add your property with details, images, and amenities
3. **Configure Rooms**: Set up different room types with various facilities
4. **Manage Bookings**: View and respond to customer reservations
5. **Customer Support**: Respond to customer inquiries via the chat system

## 🏛️ Database Schema

### Key Tables
- **accountinfo**: User profiles with authentication details
- **hotels**: Property listings with images and descriptions
- **rooms**: Room configurations with amenity arrays
- **bookings**: Reservation tracking with dates and costs
- **messages**: Real-time chat communications

## 🔧 Configuration

### Database Connection
Update the database connection string in `DatabaseClient.java`:
```java
conn = DriverManager.getConnection(
    "jdbc:postgresql://your-database-url:port/database?user=username&password=password"
);
```

### Image Storage
Images are stored as Base64 encoded strings in the database. The system handles:
- Image upload and encoding
- Automatic resizing for display
- Multiple image support per hotel

## 🎨 UI Components

The application features a modern, user-friendly interface with:
- **Responsive Design**: Adaptable layouts for different screen sizes
- **Custom Styling**: CSS-styled components for professional appearance
- **Image Galleries**: Scrollable hotel image displays
- **Form Validation**: Real-time input validation and error messaging
- **Date Pickers**: Intuitive date selection for bookings

## 🧪 Testing

The project includes JUnit test dependencies for unit testing:
```bash
mvn test
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Design Patterns in Detail

### Decorator Pattern (Room Amenities)
```java
Room room = new SingleRoom();
room = new AirConditioner(room);
room = new Balcony(room);
// Dynamic feature addition without modifying base classes
```

### Factory Pattern (Hotel Types)
```java
Hotel villa = new Villa(address, district, name, sqft);
Hotel cabin = new Cabin(address, district, name, sqft);
// Consistent hotel creation with type-specific features
```

## 🔮 Future Enhancements

- **Payment Integration**: Add payment gateway support
- **Mobile App**: Extend to mobile platforms
- **Advanced Search**: Filters for price range, ratings, and amenities
- **Review System**: Customer feedback and rating system
- **Analytics Dashboard**: Business intelligence for hotel managers
- **Multi-language Support**: Internationalization capabilities

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

Developed as an Object-Oriented Programming project demonstrating real-world application of design patterns and software engineering principles.

---

**BookStay** - Connecting travelers with their perfect accommodation! 🏨✈️