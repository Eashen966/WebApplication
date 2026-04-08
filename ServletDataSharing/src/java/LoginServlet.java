import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // semak password
        if (user != null && pass != null && user.equals("Ahmad") && pass.equals("4567")) {

            request.setAttribute("accountType", "Premium Student");
            request.setAttribute("email", "ahmad@siswa.edu.my");

            RequestDispatcher rd = request.getRequestDispatcher("AccountServlet");
            rd.forward(request, response);

        } else if (user != null && pass != null && user.equals("Siti") && pass.equals("1234")) {

            request.setAttribute("accountType", "Standard Student");
            request.setAttribute("email", "siti@siswa.edu.my");

            RequestDispatcher rd = request.getRequestDispatcher("AccountServlet");
            rd.forward(request, response);

        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3 style='color:red'>Login Failed! Invalid credentials.</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}