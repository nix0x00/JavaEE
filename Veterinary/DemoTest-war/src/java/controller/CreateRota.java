/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RotaFacade;
import model.Rota;

/**
 *
 * @author abspk
 */
@WebServlet(name = "CreateRota", urlPatterns = {"/manager/CreateRota"})
public class CreateRota extends HttpServlet {
    
    @EJB
    RotaFacade rotaFacade;
    Rota rota;
    Rota rota2;
    private String monDate, tuesdayDate, wedDate, thursDate, friDate, satDate, sunDate;
    private String monOne, monTwo, monThree;
    private String tuesOne, tuesTwo, tuesThree;
    private String wedOne, wedTwo, wedThree;
    private String thursOne, thursTwo, thursThree;
    private String friOne, friTwo, friThree;
    private String satOne, satTwo, satThree;
    private String sunOne, sunTwo, sunThree;
    private SimpleDateFormat format;
    private Date date;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            format = new SimpleDateFormat("dd/MM/yy");
            //get the dates
            monDate = request.getParameter("mondayDate");
            tuesdayDate = request.getParameter("tuesdayDate");
            wedDate = request.getParameter("wedDate");
            thursDate = request.getParameter("thursDate");
            friDate = request.getParameter("friDate");
            satDate = request.getParameter("satDate");
            sunDate = request.getParameter("sunDate");
            
            //get vet details
            monOne = request.getParameter("monday");
            monTwo = request.getParameter("monday2");
            monThree = request.getParameter("monday3");
            tuesOne = request.getParameter("tuesday");
            tuesTwo = request.getParameter("tuesday2");
            tuesThree = request.getParameter("tuesday3");
            wedOne = request.getParameter("wednesday");
            wedTwo = request.getParameter("wednesday2");
            wedThree = request.getParameter("wednesday3");
            thursOne = request.getParameter("thursday");
            thursTwo = request.getParameter("thursday2");
            thursThree = request.getParameter("thursday3");
            friOne = request.getParameter("friday");
            friTwo = request.getParameter("friday2");
            friThree = request.getParameter("friday3");
            satOne = request.getParameter("saturday");
            satTwo = request.getParameter("saturday2");
            satThree = request.getParameter("saturday3");
            sunOne = request.getParameter("sunday");
            sunTwo = request.getParameter("sunday2");
            sunThree = request.getParameter("sunday3");
            
            //monday
            rota = new Rota();
            try {
                date = format.parse(monDate);
            } catch(ParseException x) {
                x.printStackTrace();
            }
            rota.setRotaDay("Monday");
            rota.setRotaDate(date);
            rota.setFirstVet(monOne);
            rota.setSecondVet(monTwo);
            rota.setThirdVet(monThree);
            rotaFacade.create(rota);
            
            //tuesday
            rota = new Rota();
            try {
                date = format.parse(tuesdayDate);
            } catch(ParseException x) {
                x.printStackTrace();
            }
            rota.setRotaDay("Tuesday");
            rota.setRotaDate(date);
            rota.setFirstVet(tuesOne);
            rota.setSecondVet(tuesTwo);
            rota.setThirdVet(tuesThree);
            rotaFacade.create(rota);
            
            //wednesday
            rota = new Rota();
            try {
                date = format.parse(wedDate);
            } catch(ParseException x) {
                x.printStackTrace();
            }
            rota.setRotaDay("Wednesday");
            rota.setRotaDate(date);
            rota.setFirstVet(wedOne);
            rota.setSecondVet(wedTwo);
            rota.setThirdVet(wedThree);
            rotaFacade.create(rota);
            
            //thursday
            rota = new Rota();
            try {
                date = format.parse(thursDate);
            } catch(ParseException x) {
                x.printStackTrace();
            }
            rota.setRotaDay("Thursday");
            rota.setRotaDate(date);
            rota.setFirstVet(thursOne);
            rota.setSecondVet(thursTwo);
            rota.setThirdVet(thursThree);
            rotaFacade.create(rota);
            
            //friday
            rota2 = new Rota();
            try {
                date = format.parse(friDate);
            } catch(ParseException x) {
                x.printStackTrace();
            }
            rota2.setRotaDay("Friday");
            rota2.setRotaDate(date);
            rota2.setFirstVet(friOne);
            rota2.setSecondVet(friTwo);
            rota2.setThirdVet(friThree);
            rotaFacade.create(rota2);
            
            //saturday
            rota2 = new Rota();
            try {
                date = format.parse(satDate);
            } catch(ParseException x) {
                x.printStackTrace();
            }
            rota2.setRotaDay("Saturday");
            rota2.setRotaDate(date);
            rota2.setFirstVet(satOne);
            rota2.setSecondVet(satTwo);
            rota2.setThirdVet(satThree);
            rotaFacade.create(rota2);
            
            //sunday
            rota2 = new Rota();
            try {
                date = format.parse(sunDate);
            } catch(ParseException x) {
                x.printStackTrace();
            }
            rota2.setRotaDay("Sunday");
            rota2.setRotaDate(date);
            rota2.setFirstVet(sunOne);
            rota2.setSecondVet(sunTwo);
            rota2.setThirdVet(sunThree);
            rotaFacade.create(rota2);
            
            request.getRequestDispatcher("./index.jsp").include(request, response);
        } catch(Exception x) {
            request.getRequestDispatcher("./index.jsp").include(request, response);
            out.print("Error: Please choose the corect date!");
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
