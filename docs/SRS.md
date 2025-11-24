# Software Requirements Specification (SRS)

**Project Title:** Mini Blogging Website  
**Prepared by:** Areeba & Team  
**Course:** Software Construction & Development (SCD)  

---

## 1. Introduction

### 1.1 Purpose
The purpose of this project is to develop a **Mini Blogging Website** where users can register, log in, create blogs, view posts, and manage their content. The system will be user-friendly, simple, and will gradually cover concepts of **frontend, backend, database connectivity, UML diagrams, and version control** as part of the course.

### 1.2 Scope
- **Guest Users**: Can view blogs, search blogs, and register/login.  
- **Registered Users**: Can log in, write blogs, edit/delete their own posts, update profile, and view a personalized dashboard.  
- **System**: Validates users, stores blog posts, and manages user accounts.  
- The project emphasizes **front-end design**, **basic Java OOP backend**, and **JDBC** for database.  

### 1.3 Definitions, Acronyms, Abbreviations
- **SRS**: Software Requirements Specification  
- **DB**: Database  
- **UI**: User Interface  
- **JDBC**: Java Database Connectivity  

---

## 2. Overall Description

### 2.1 User Classes
- **Guest**: Not logged in, can only view and search blogs.  
- **Registered User**: Can log in and perform full blog operations.  

### 2.2 Product Functions
- Sign Up & Login  
- Write, Edit, Delete Blog  
- View Blogs (all users)  
- Search Blogs  
- Categorize Blogs  
- User Dashboard  
- Update Profile  
- Logout  

### 2.3 Constraints
- Minimal backend Java code only (for learning OOP + JDBC).  
- Database setup through JDBC.  
- Simple UI (HTML, CSS, Bootstrap).  

### 2.4 Assumptions & Dependencies
- Users must have internet and a modern browser.  
- Database must be connected properly.  
- GitHub is used for version control.  

---

## 3. Specific Requirements

### 3.1 Functional Requirements

| ID     | Requirement                                                                 |
|--------|------------------------------------------------------------------------------|
| FR1    | System shall allow users to register with username, email, and password.    |
| FR2    | System shall allow registered users to log in with valid credentials.       |
| FR3    | System shall prevent login with invalid credentials.                        |
| FR4    | System shall allow users to log out of the system.                          |
| FR5    | System shall allow users to write a new blog (title + content + category).  |
| FR6    | System shall allow users to edit only their own blogs.                      |
| FR7    | System shall allow users to delete only their own blogs.                    |
| FR8    | System shall confirm deletion with a dialog box.                            |
| FR9    | System shall allow all users (guest + registered) to view blogs.            |
| FR10   | System shall display blogs with title, author, and content.                 |
| FR11   | System shall allow users to search blogs by title or keyword.               |
| FR12   | System shall allow users to categorize blogs (e.g., Tech, Education).       |
| FR13   | System shall allow registered users to update their profile details.        |
| FR14   | System shall provide a dashboard for registered users showing their posts.  |
| FR15   | System shall maintain session until logout or timeout.                      |

### 3.2 Non-Functional Requirements

| Category      | Requirement                                                                 |
|---------------|-----------------------------------------------------------------------------|
| Usability     | The system shall have a simple, responsive UI with Bootstrap.              |
| Performance   | Pages shall load within 2 seconds.                                         |
| Security      | Passwords shall be stored securely in the database.                        |
| Reliability   | The system shall support at least 20 concurrent users.                     |
| Portability   | The website shall run on all modern browsers (Chrome, Edge, Firefox).      |
| Maintainable  | Code shall follow modular design (Java classes + JDBC).                    |

---

## 4. System Models

The following UML diagrams will represent the system:

- **Use Case Diagram:** Shows interactions between Guest, Registered User, and the system.  
- **Class Diagram:** Represents the structure of User, Post, DatabaseHandler, and BlogSystem.  
- **Sequence Diagrams:** Show step-by-step interactions for Login, Create Blog, Edit Blog, Delete Blog, and View Posts.  

---

## 5. Tools & Technologies

- **Frontend:** HTML, CSS, Bootstrap  
- **Backend:** Java (Servlets, OOP concepts)  
- **Database:** MySQL with JDBC  
- **Version Control:** GitHub  
- **Modeling:** UML diagrams with PlantUML / draw.io  

---

## 6. References

- IEEE Standard for SRS Documentation  
- Course Material: Software Construction & Development  
- PlantUML & Draw.io Documentation  

---
