package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.bo.custom.OrderDetailsBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.dto.OrderDetailsDTO;
import lk.ijse.pos.entitiy.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsBOImpl implements OrderDetailsBO, SuperBO {
    private final OrderDetailsDAO orderDetailDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetails> all = orderDetailDAO.getAll(connection);
        ArrayList<OrderDetailsDTO> orderDetails = new ArrayList<>();

        for (OrderDetails orderDetail : all) {
            orderDetails.add(new OrderDetailsDTO(orderDetail.getOrderId(), orderDetail.getCode(), orderDetail.getPrice(), orderDetail.getQty()));
        }

        return orderDetails;
    }
}
