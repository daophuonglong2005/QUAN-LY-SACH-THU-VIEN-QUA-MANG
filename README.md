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
- **Đăng nhập/Đăng ký** người dùng và admin.
- **Mượn và trả sách**: ghi nhận trên server.
- **Lưu trữ dữ liệu**: MySQL.
- **Trao đổi dữ liệu** qua TCP.
- **Quản lý sách** admin
- **Quản lý mượn trả** Người dùng gửi yêu cầu mượn sách.
- **Kết nối mạng Client – Server (TCP)** Client kết nối bằng Socket tới server
- **Quản lý người dùng & phân quyền** Người dùng thường: mượn, trả, xem sách. Quản trị viên: thêm/sửa/xóa sách, xem danh sách mượn.


## 🔧 2. Ngôn ngữ lập trình sử dụng: [![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
- **Ngôn ngữ lập trình**: Java  
- **Giao diện**: Java Swing  
- **Mạng**: TCP Socket  
- **Lưu trữ dữ liệu**:
  - MySQL 
- **Môi trường phát triển**: Eclipse IDE
- **Hệ điều hành**: Windows
  
## 🚀 3. Hình ảnh giao diện
<div align="center">
<table>
  <tr>
      <td align="center">
      <img width="100%" alt="Screenshot 2025-09-19 061113" src="https://github.com/user-attachments/assets/61715019-7c2e-416a-8fb9-893f1b6f03ee" /><br/>
      <b>Hình 1: Trang đăng nhập, đăng kí</b>
    </td>
  </tr>
</table>
</div>
<div align="center">
<table>
  <tr>
      <td align="center">
      <img width="100%" alt="Screenshot 2025-09-19 061113" src="https://github.com/user-attachments/assets/c4c88331-39ae-4fdc-b6af-e0501f535fef" /><br/>
      <b>Hình 2: Giao diện người dùng: Danh sách sách</b>
    </td>
  </tr>
</table>
</div>
<div align="center">
<table>
  <tr>
      <td align="center">
      <img width="100%" alt="Screenshot 2025-09-19 061113" src="https://github.com/user-attachments/assets/4bc164ee-30bb-4fe0-9311-49a8abd981ab" /><br/>
      <b>Hình 3: Giao diện người dùng: Sách của tôi</b>
    </td>
  </tr>
</table>
</div>
<div align="center">
<table>
  <tr>
      <td align="center">
      <img width="100%" alt="Screenshot 2025-09-19 061113" src="https://github.com/user-attachments/assets/16ec3017-398d-4306-a225-9be5141be9c3" /><br/>
      <b>Hình 4: Giao diện người dùng: Yêu cầu mượn</b>
    </td>
  </tr>
</table>
</div>
<div align="center">
<table>
  <tr>
      <td align="center">
      <img width="100%" alt="Screenshot 2025-09-19 061113" src="https://github.com/user-attachments/assets/0ade0b29-7db3-4c23-9769-4900923e9b69" /><br/>
      <b>Hình 5: Giao diện admin: Danh sách sách</b>
    </td>
  </tr>
</table>
</div>
<div align="center">
<table>
  <tr>
      <td align="center">
      <img width="100%" alt="Screenshot 2025-09-19 061113" src="https://github.com/user-attachments/assets/e4234e1d-4971-4d93-8a5e-28d11b0dcb89" /><br/>
      <b>Hình 6: Giao diện admin: Sách của tôi</b>
    </td>
  </tr>
</table>
</div>
<div align="center">
<table>
  <tr>
      <td align="center">
      <img width="100%" alt="Screenshot 2025-09-19 061113" src="https://github.com/user-attachments/assets/1d6e07d1-9938-4556-a027-1a5c9cc587e0" /><br/>
      <b>Hình 7: Giao diện admin: Yêu cầu mượn</b>
    </td>
  </tr>
</table>
</div>






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
