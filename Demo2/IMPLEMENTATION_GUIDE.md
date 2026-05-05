# ComboBox Form Implementation - Documentation

## Overview
This implementation adds a complete Student Registration Form (Khai báo Sinh Viên) with ComboBox data binding, validation, and database persistence.

## Created Files

### 1. **Entity Classes**
   - `Table_SV.kt` (Updated) - Student entity with JPA mapping
   - `Truong.java` - School/University entity
   - `Nganh.java` - Major/Specialization entity

### 2. **Repository Interfaces**
   - `SinhVienRepository.java` - JPA Repository for Student
   - `TruongRepository.java` - JPA Repository for School
   - `NganhRepository.java` - JPA Repository for Major

### 3. **DTO/Form Class**
   - `SinhVienForm.java` - Data Transfer Object with validation annotations:
     - @NotBlank - Required fields
     - @Email - Email format validation
     - @Pattern - Phone number validation (10-11 digits)
     - @PastOrPresent - Graduation date validation

### 4. **Controller**
   - `SinhVienController.java` - Handles:
     - GET /sinh-vien/khai-bao - Display form with ComboBox data
     - POST /sinh-vien/luu-thong-tin - Save student data with validation
     - GET /sinh-vien/success - Success page

### 5. **Templates (Thymeleaf)**
   - `khai-bao-form.html` - Main form with:
     - Input fields for student info
     - ComboBox for School selection
     - ComboBox for Major selection
     - Date picker for graduation date
     - Validation error display
     - Responsive design with CSS styling
   - `success.html` - Success confirmation page

### 6. **Configuration**
   - `application.properties` (Updated) - Fixed typo and added Hibernate dialect

## Features Implemented

### 1. **ComboBox Data Binding**
   ```html
   <select th:field="*{maTruong}">
       <option th:each="t : ${dsTruong}" 
               th:value="${t.maTruong}" 
               th:text="${t.tenTruong}"></option>
   </select>
   ```

### 2. **Form Validation**
   - Required fields (CMND, Name, Address, Email, Phone, School, Major, Graduation Date)
   - Email format validation
   - Phone number format (10-11 digits)
   - Graduation date cannot be in the future
   - Real-time error display on form

### 3. **Data Flow**
   1. User accesses `/sinh-vien/khai-bao`
   2. Controller loads all Schools and Majors from database
   3. ComboBox options are populated with Thymeleaf template
   4. User fills form and submits
   5. Validation occurs on server-side
   6. If valid: Save to database and redirect to success page
   7. If invalid: Reload form with error messages

### 4. **Responsive UI**
   - Modern gradient background
   - Styled form with focus states
   - Error highlighting with red borders
   - Mobile-friendly design
   - Success page with return link

## How to Use

### 1. **Ensure Database Tables Exist**
   The application will auto-create tables with `spring.jpa.hibernate.ddl-auto=update`

   If you need to manually create them:
   ```sql
   CREATE TABLE Truong (
       maTruong VARCHAR(50) PRIMARY KEY,
       tenTruong VARCHAR(255),
       diaChi VARCHAR(255)
   );

   CREATE TABLE Nganh (
       maNganh VARCHAR(50) PRIMARY KEY,
       tenNganh VARCHAR(255),
       maTruong VARCHAR(50)
   );

   CREATE TABLE SinhVien (
       soCMND VARCHAR(50) PRIMARY KEY,
       hoTen VARCHAR(255),
       diaChi VARCHAR(255),
       email VARCHAR(255),
       soDT VARCHAR(20)
   );
   ```

### 2. **Populate ComboBox Data**
   Insert sample data into TRUONG and NGANH:
   ```sql
   INSERT INTO Truong VALUES ('T001', 'Đại Học Kinh Tế Tp.HCM', '123 Đường 1, Q1');
   INSERT INTO Truong VALUES ('T002', 'Đại Học Đà Nẵng', 'Đà Nẵng');
   
   INSERT INTO Nganh VALUES ('N001', 'Kế Toán', 'T001');
   INSERT INTO Nganh VALUES ('N002', 'Công Nghệ Thông Tin', 'T001');
   INSERT INTO Nganh VALUES ('N003', 'Quản Lý Bán Hàng', 'T002');
   ```

### 3. **Access the Form**
   Navigate to: `http://localhost:8080/sinh-vien/khai-bao`

## Validation Rules

| Field | Rules |
|-------|-------|
| Số CMND | Required |
| Họ Tên | Required |
| Địa Chỉ | Required |
| Email | Required, Valid email format |
| Số ĐT | Required, 10-11 digits |
| Trường | Required, Select from ComboBox |
| Ngành | Required, Select from ComboBox |
| Ngày TN | Required, Cannot be future date |

## Dependencies
- Spring Boot 4.0.6
- Spring Data JPA
- Thymeleaf
- Jakarta Persistence API
- Jakarta Validation API (Bean Validation)
- MySQL Connector

All dependencies are already configured in `pom.xml`

## File Structure
```
src/main/
├── java/com/example/demo2/
│   ├── Table_SV.kt
│   ├── controller/
│   │   └── SinhVienController.java
│   ├── entity/
│   │   ├── Truong.java
│   │   └── Nganh.java
│   ├── dto/
│   │   └── SinhVienForm.java
│   └── repository/
│       ├── SinhVienRepository.java
│       ├── TruongRepository.java
│       └── NganhRepository.java
└── resources/
    ├── templates/
    │   ├── khai-bao-form.html
    │   └── success.html
    └── application.properties
```

## Notes
- All validations are performed server-side using Bean Validation
- Database connection requires MySQL running on localhost:3306
- Credentials: username=root, password=123456
- The DTD-auto is set to "update" which will auto-create/update tables

