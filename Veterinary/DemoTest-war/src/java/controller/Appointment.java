package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vet;
import model.VetFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "Appointment", urlPatterns = {"/receptionist/Appointment"})
public class Appointment extends HttpServlet {
    
    @EJB
    VetFacade vetFacade;
    List<Vet> vet = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            vet = new ArrayList<Vet>();
            vet = vetFacade.findAll();
            request.setAttribute("vetList", vet);
            request.getRequestDispatcher("./create-appointment.jsp").include(request, response);
        } catch(Exception x) {
            x.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
