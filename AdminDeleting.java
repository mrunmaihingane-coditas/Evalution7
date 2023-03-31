import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/AdminDeleting")
public class AdminDeleting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("I AM EDITINd DELETING ANUJA ");
        out.println("<br>");
        out.println("<br>");
        ServletContext sr = getServletContext();
        try {
            Class.forName(sr.getInitParameter("driver"));

            Connection con = DriverManager.getConnection(sr.getInitParameter("url"), sr.getInitParameter("username"), sr.getInitParameter("password"));
            out.println("JDBC Connection Done");
            out.println("<br>");
            out.println("<br>");
            PreparedStatement st = con.prepareStatement("DELETE FROM users WHERE name=sam");
            st.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }




    }
}
