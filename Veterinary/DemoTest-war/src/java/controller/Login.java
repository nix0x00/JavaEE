/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Manager;
import model.ManagerFacade;
import model.Receptionist;
import model.ReceptionistFacade;
import model.Staff;
import model.StaffFacade;
import model.Vet;
import model.VetFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    @EJB
    ManagerFacade managerFacade;
    Manager manager;
    @EJB
    ReceptionistFacade receptionistFacade;
    Receptionist receptionist;
    @EJB
    StaffFacade staffFacade;
    Staff staff;
    @EJB
    VetFacade vetFacade;
    Vet vet;
    
    private boolean isFalse = false;
    private String type;
    private HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            type = request.getParameter("type");
            String user = request.getParameter("username");
            String pwd = request.getParameter("password");
            byte[] salt = new String("12345678").getBytes();
            // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
            int iterationCount = 40000;
            // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
            int keyLength = 128;
            SecretKeySpec key = createSecretKey(pwd.toCharArray(),
                    salt, iterationCount, keyLength);
            
            switch(type) {
                case "manager":
                    isFalse = managerFacade.getLogin(user, pwd);
                    if(isFalse) {
                        session = request.getSession(true);
                        session.setAttribute("username", user);
                        session.setAttribute("type", "manager");
                        response.sendRedirect("./manager/index.jsp");
                    } else {
                        response.sendRedirect("./auth/login.jsp?b=true");
                    }
                    break;
                case "staff":
                    isFalse = staffFacade.getLogin(user, pwd, key);
                    if(isFalse) {
                        session = request.getSession(true);
                        session.setAttribute("username", user);
                        session.setAttribute("type", "staff");
                        response.sendRedirect("./staff/index.jsp");
                    } else {
                        //request.getRequestDispatcher("./auth/login.jsp?b=true").forward(request, response);
                        response.sendRedirect("./auth/login.jsp?b=true");
                    }
                    break;
                case "vet":
                    isFalse = vetFacade.getLogin(user, pwd);
                    if(isFalse) {
                        session = request.getSession(true);
                        session.setAttribute("username", user);
                        session.setAttribute("type", "vet");
                        response.sendRedirect("./vet/index.jsp");
                        
                    } else {
                        response.sendRedirect("./auth/login.jsp?b=true");
                    }
                    break;
                case "receptionist":
                    isFalse = receptionistFacade.getLogin(user, pwd);
                    if(isFalse) {
                        session = request.getSession(true);
                        session.setAttribute("username", user);
                        session.setAttribute("type", "receptionist");
                        response.sendRedirect("./receptionist/index.jsp");
                    } else {
                        response.sendRedirect("./auth/login.jsp?b=true");
                    }
                    break;
                default:
                    response.sendRedirect("./auth/login.jsp?c=true");
                    break;
            }
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
    
    private static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKey keyTmp = keyFactory.generateSecret(keySpec);
        return new SecretKeySpec(keyTmp.getEncoded(), "AES");
    }
}
