<h2 align="center">
    <a href="https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin">
    🎓 Faculty of Information Technology (DaiNam University)
    </a>
</h2>
<h2 align="center">
   QUẢN LÝ SÁCH - THƯ VIỆN QUA MẠNG
</h2>
<div align="center">
    <p align="center">
        <img src="https://github.com/user-attachments/assets/433b71ad-8a82-44c4-a58a-5d284c17542f" width="170"/>
        <img src="https://github.com/user-attachments/assets/ef59df2c-bbad-4ee4-a890-80139f545c8c" width="180"/>
        <img src="https://github.com/user-attachments/assets/494b660e-72c2-47fe-b311-127fe9be0d8c" width="200"/>
    </p>


[![AIoTLab](https://img.shields.io/badge/AIoTLab-green?style=for-the-badge)](https://www.facebook.com/DNUAIoTLab)
[![Faculty of Information Technology](https://img.shields.io/badge/Faculty%20of%20Information%20T…he-badge)](https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin)
[![DaiNam University](https://img.shields.io/badge/DaiNam%20University-orange?style=for-the-badge)](https://dainam.edu.vn)


</div>


## 📖 1. Giới thiệu

**Quản lý sách – Thư viện số** là một ứng dụng mô phỏng hệ thống thư viện trực tuyến, được phát triển theo mô hình **Client – Server**.
Trong đó:

* **Server** chịu trách nhiệm quản lý dữ liệu (người dùng, sách, mượn/trả) và xử lý các yêu cầu từ Client thông qua giao thức TCP.
* **Client** cung cấp giao diện trực quan (Java Swing) cho người dùng để đăng nhập, tìm kiếm, mượn và trả sách từ xa.

Ứng dụng sử dụng **giao thức TCP Socket** để trao đổi dữ liệu giữa Client và Server, đảm bảo quá trình truyền thông tin ổn định và tin cậy.
Dữ liệu được lưu trữ và quản lý trong **MySQL Database** để hỗ trợ đầy đủ các chức năng CRUD (Create – Read – Update – Delete).

---

📌 **Mục tiêu**

* Xây dựng một hệ thống thư viện số cơ bản, có thể mở rộng và dễ sử dụng.
* Tách biệt rõ ràng giữa **tầng giao diện (Client)** và **tầng xử lý dữ liệu (Server)**.
* Tận dụng giao thức **TCP** để mô phỏng mô hình mạng thực tế.

  ### ✨ Các chức năng chính
- **Đăng nhập/Đăng ký** người dùng.
- **Mượn và trả sách**: ghi nhận trên server.
- **Lưu trữ dữ liệu**: MySQL.
- **Trao đổi dữ liệu** qua TCP.

## 🔧 2. Ngôn ngữ lập trình sử dụng: [![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
- **Ngôn ngữ lập trình**: Java  
- **Giao diện**: Java Swing  
- **Mạng**: TCP Socket  
- **Lưu trữ dữ liệu**:
  - MySQL 
- **Môi trường phát triển**: Eclipse IDE
- **Hệ điều hành**: Windows
  
## 🚀 3. Hình ảnh giao diện

<p align="center">
  <img src="https://github.com/user-attachments/assets/d6c44ce0-a052-4b24-971d-5d627a03f2f7" alt="Ảnh 1" width="700"/>
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/7e349714-bc47-4685-856f-43386424d725" alt="Ảnh 2" width="700"/>
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/315f1857-1dad-4a9d-9fec-dd48a24db378" alt="Ảnh 3" width="700"/>
</p>



## 📝 4. Hướng dẫn cài đặt và sử dụng

### 🔧 Yêu cầu hệ thống
- **Java Development Kit (JDK)**: Phiên bản 8 trở lên  
- **Hệ điều hành**: Windows / macOS / Linux  
- **IDE khuyến nghị**: IntelliJ IDEA, Eclipse, hoặc NetBeans
- **Bộ nhớ**: Tối thiểu 512MB RAM  

---

### 📦 Các bước triển khai
#### 🔹 Bước 1: Chuẩn bị môi trường
1. **Cài đặt JDK** nếu chưa có:  
   - Kiểm tra bằng lệnh:  
     ```bash
     java -version
     javac -version
     ```
   - Nếu chưa có, tải JDK tại [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) hoặc [OpenJDK](https://adoptium.net/).

2. **Tải mã nguồn dự án**:  
   - Clone repo bằng Git:  
     ```bash
     https://github.com/daophuonglong2005/QUAN-LY-SACH-THU-VIEN-QUA-MANG/tree/main
     ```
   - Hoặc tải file `.zip` và giải nén.

---

#### 🔹 Bước 2: Biên dịch mã nguồn
Di chuyển đến Project
#### 🔹 Bước 3: Chạy file LibraryServer.java

#### 🔹 Bước 4: Chạy file ClientUI.java
- Giao diện thư viện sẽ hiện ra

## 👤 5. Liên hệ
**Họ tên**: Đào Thị Phương Long.  
**Lớp**: CNTT 16-01.  
**Email**: Daophuonglong2524@gmail.com.

© 2025 Faculty of Information Technology, DaiNam University. All rights reserved.

---
