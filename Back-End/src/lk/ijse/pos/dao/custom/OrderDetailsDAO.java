package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entitiy.OrderDetails;

import java.sql.Connection;

public interface OrderDetailsDAO extends CrudDAO<Connection, OrderDetails, String> {
}
