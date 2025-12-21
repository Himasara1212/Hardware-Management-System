package lk.ijse.gdse.hardwaremanagementsystem.model;

import lk.ijse.gdse.hardwaremanagementsystem.db.DBConnection;
import lk.ijse.gdse.hardwaremanagementsystem.dto.CategoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryModel {

    public ArrayList<CategoryDto> getAllCategories() throws Exception {

        ArrayList<CategoryDto> categoryList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM categories";

        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();

        while (rst.next()) {
            CategoryDto dto = new CategoryDto();
            dto.setCategory_id(rst.getString("category_id"));
            dto.setName(rst.getString("name"));

            categoryList.add(dto);
        }

        return categoryList;
    }
}
