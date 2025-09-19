package server.network;

import common.dto.BookDTO;
import common.dto.BorrowRecordDTO;
import common.dto.UserDTO;
import common.protocol.Request;
import common.protocol.Response;
import server.model.Book;
import server.model.BorrowRecord;
import server.model.User;
import server.service.BookService;
import server.service.BorrowService;
import server.service.UserService;

import java.util.stream.Collectors;

public class RequestProcessor {
    private static UserService userService = new UserService();
    private static BookService bookService = new BookService();
    private static BorrowService borrowService = new BorrowService();

    public static Response process(Request req) {
        switch (req.getAction()) {
        case "LOGIN":
            UserDTO uDto = (UserDTO) req.getData();
            User u = userService.login(uDto.getUsername(), uDto.getPassword());
            if (u != null) {
                UserDTO dto = new UserDTO(
                    u.getId(), u.getUsername(), u.getPassword(),
                    u.getName(), u.getEmail(), u.getPhone(), u.getRole()
                );
                return new Response(true, "Đăng nhập thành công", dto);
            } else {
                return new Response(false, "Sai tài khoản hoặc mật khẩu", null);
            }


            case "REGISTER":
                UserDTO regDto = (UserDTO) req.getData();
                User newUser = new User();
                newUser.setUsername(regDto.getUsername());
                newUser.setPassword(regDto.getPassword());
                newUser.setName(regDto.getName());
                newUser.setEmail(regDto.getEmail());
                newUser.setPhone(regDto.getPhone());
                boolean ok = userService.register(newUser);
                return new Response(ok, ok ? "Đăng ký thành công" : "Đăng ký thất bại", null);

            case "GET_BOOKS":
                return new Response(true, "Danh sách sách", bookService.getAll()
                        .stream().map(b -> new BookDTO(
                                b.getId(), b.getTitle(), b.getAuthor(),
                                b.getCategory(), b.getPublisher(),
                                b.getYear(), b.getQuantity()
                        )).collect(Collectors.toList()));

            // 🟦 Mượn sách
            case "BORROW_BOOK":
                BorrowRecordDTO brDto = (BorrowRecordDTO) req.getData();
                BorrowRecord br = new BorrowRecord();
                br.setUserId(brDto.getUserId());
                br.setBookId(brDto.getBookId());
                br.setBorrowDate(brDto.getBorrowDate());
                br.setDueDate(brDto.getDueDate());
                br.setStatus("BORROWED");
                boolean borrowOk = borrowService.add(br);
                return new Response(borrowOk,
                        borrowOk ? "Mượn sách thành công" : "Mượn sách thất bại", null);

            // 🟦 Trả sách
            case "RETURN_BOOK":
                int recordId = (int) req.getData();
                boolean returnOk = borrowService.updateReturn(recordId);
                return new Response(returnOk,
                        returnOk ? "Trả sách thành công" : "Trả sách thất bại", null);

            // 🟦 Danh sách mượn trả
            case "GET_BORROW_RECORDS":
                return new Response(true, "Danh sách mượn trả", borrowService.getAll()
                        .stream().map(r -> new BorrowRecordDTO(
                                r.getId(), r.getUserId(), r.getBookId(),
                                r.getBorrowDate(), r.getDueDate(),
                                r.getReturnDate(), r.getStatus()
                        )).collect(Collectors.toList()));

            default:
                return new Response(false, "Yêu cầu không hợp lệ", null);
        }
    }
}
