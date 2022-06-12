package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.AttractionBean;

public class AttractionDAO {
	private String url = "jdbc:postgresql:postgres";
	private String user = "user1";
	private String pass = "himitu";
	
	public AttractionDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}
	
	public List<AttractionBean> findAttraction() throws DAOException {
		
		String sql = "SELECT * FROM attraction ORDER BY attraction_id";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			
			List<AttractionBean> list = new ArrayList<AttractionBean>();
			while (rs.next()) {
				int attractionId = rs.getInt("attraction_id");
				String attractionName = rs.getString("attraction_name");
				int price = rs.getInt("price");
				AttractionBean bean = new AttractionBean(attractionId, attractionName, price);
				list.add(bean);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
}
