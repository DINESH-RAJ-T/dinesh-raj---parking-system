import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpaceManager {
    public List<ParkingSpace> getAllParkingSpaces() throws SQLException {
        List<ParkingSpace> parkingSpaces = new ArrayList<>();
        String query = "SELECT * FROM ParkingSpaces";

        try (Connection connection = DatabaseUtility.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                ParkingSpace parkingSpace = new ParkingSpace(
                    resultSet.getInt("id"),
                    resultSet.getString("location")
                );
                parkingSpaces.add(parkingSpace);
            }
        }
        return parkingSpaces;
    }

    public void updateParkingSpace(int id, boolean isOccupied) throws SQLException {
        String query = "UPDATE ParkingSpaces SET isOccupied = ? WHERE id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, isOccupied);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }
}