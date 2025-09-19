package server.service;

import server.dao.BorrowRecordDAO;
import server.model.BorrowRecord;

import java.util.List;

public class BorrowService {
    private BorrowRecordDAO dao = new BorrowRecordDAO();

    public boolean add(BorrowRecord br) {
        return dao.add(br);
    }

    public List<BorrowRecord> getAll() {
        return dao.getAll();
    }
    public boolean updateReturn(int recordId) {
        return dao.updateReturn(recordId);
    }

}
