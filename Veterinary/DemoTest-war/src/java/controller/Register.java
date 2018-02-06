/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    
    private String firstName;
    private String lastName;
    private String email;
    private String pwd;
    private String type;
    private String vetType;
    private String speciality;
    
    @EJB
            ManagerFacade managerFacade;
    Manager manager;
    @EJB
            VetFacade vetFacade;
    Vet doctor;
    @EJB
            StaffFacade staffFacade;
    Staff staffMember;
    @EJB
            ReceptionistFacade receptionistFacade;
    Receptionist receptionist;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            firstName = request.getParameter("firstname");
            lastName = request.getParameter("lastname");
            email = request.getParameter("email");
            pwd = request.getParameter("password");
            type = request.getParameter("type");
            vetType = request.getParameter("vetType");
            speciality = request.getParameter("speciality");
            
            byte[] salt = new String("12345678").getBytes();
            // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
            int iterationCount = 40000;
            // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
            int keyLength = 128;
            SecretKeySpec key = createSecretKey(pwd.toCharArray(),
                    salt, iterationCount, keyLength);
            switch(type) {
                case "manager":
                    manager = new Manager();
                    manager.setEmail(email);
                    manager.setFirstName(firstName);
                    manager.setLastName(lastName);
                    manager.setPwd(pwd);
                    
                    managerFacade.create(manager);
                    response.sendRedirect("./auth/success.jsp?url=../manager/index.jsp");
                    break;
                case "vet":
                    doctor = new Vet();
                    doctor.setSpeciality(vetType);
                    doctor.setSecondSpeciality(speciality);
                    doctor.setEmail(email);
                    doctor.setFirstName(firstName);
                    doctor.setLastName(lastName);
                    doctor.setPwd(pwd);
                    
                    vetFacade.create(doctor);
                    response.sendRedirect("./auth/success.jsp?url=../manager/index.jsp");
                    break;
                case "receptionist":
                    receptionist = new Receptionist();
                    receptionist.setEmail(email);
                    receptionist.setFirstName(firstName);
                    receptionist.setLastName(lastName);
                    receptionist.setPwd(pwd);
                    
                    receptionistFacade.create(receptionist);
                    response.sendRedirect("./auth/success.jsp?url=../manager/index.jsp");
                    break;
                case "staff":
                    staffMember = new Staff();
                    staffMember.setEmail(email);
                    staffMember.setFirstName(firstName);
                    String passwd = encrypt(pwd, key);
                    staffMember.setPwd(passwd);
                    staffMember.setLastName(lastName);
                    
                    staffFacade.create(staffMember);
                    response.sendRedirect("./auth/success.jsp?url=../manager/index.jsp");
                    break;
                default:
                    response.sendRedirect("./auth/register.jsp?c=true");
            }
        } catch(Exception x) {
            response.sendRedirect("./auth/register.jsp?c=true");
            x.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch(Exception x) {
            
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch(Exception x) {
            
        }
    }
    
    private static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKey keyTmp = keyFactory.generateSecret(keySpec);
        return new SecretKeySpec(keyTmp.getEncoded(), "AES");
    }
    
    private static String encrypt(String property, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters parameters = pbeCipher.getParameters();
        IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
        byte[] cryptoText = pbeCipher.doFinal(property.getBytes("UTF-8"));
        byte[] iv = ivParameterSpec.getIV();
        return base64Encode(iv) + ":" + base64Encode(cryptoText);
    }
    
    private static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
    
    private static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
        String iv = string.split(":")[0];
        String property = string.split(":")[1];
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }
    
    private static byte[] base64Decode(String property) throws IOException {
        return Base64.getDecoder().decode(property);
    }
}
