package com.uniovi.sdi.complementarios;

import com.uniovi.sdi.Product;
import com.uniovi.sdi.ProductsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletComplementario1", value = "/products")//Aquí se crea el Servlet para el complementario 1
public class ServletComplementario1 extends HttpServlet {
    List<Product> storeProducts = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductsService pService = new ProductsService();
        storeProducts =  pService.getProducts();
        request.setAttribute("storedProducts", storeProducts);
        getServletContext().getRequestDispatcher("/complementarios/products-view.jsp").forward(request, response);//le enviamos al jsp una response con los productos
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
