package hu.forest.jeehazi;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */
/*Egy servlet létrehozása a JavaEE világban nagyon  egyszerű: leszármaztatjuk az osztályunkat a HttpServlet
absztrakt osztályból, feltesszük a @WebServlet annótációt, melyben az urlPatterns paraméterében megadjuk, hogy
mely útvonal esetén hívódjon meg, majd felüldefiniáljuk a kívánt metódust, mely esetünkben a doGet.*/

@WebServlet(urlPatterns="/personServlet")
public class TempPersonServlet extends HttpServlet{

    @Inject
    private TempPersonBean tempPersonBean;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        tempPersonBean.setName(httpServletRequest.getParameter("name"));
        httpServletResponse.sendRedirect("index.jsp");
    }}
