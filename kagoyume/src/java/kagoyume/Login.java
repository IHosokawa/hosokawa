/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author You
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
        HttpSession session = request.getSession();
        
        try {
            if(!session.getAttribute("Login").equals("ll")){

                if(request.getParameter("beforeUrl") == null){
                    //ログアウト状態でのログイン画面への遷移
                    //遷移前のURLを取得し必要な情報をセッションに保存
                    String beforeUrl = request.getHeader("REFERER");
                    beforeUrl = beforeUrl.substring(beforeUrl.indexOf("kagoyume/") + 9);
                    session.setAttribute("BeforeUrl", beforeUrl);

                    session.setAttribute("logac", (int) (Math.random() * 1000));
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }else{
                    //ユーザー名とパスワードを入力されたときの処理
                    UserDataDTO ud = new UserDataDTO();
                    ud.setName((String)request.getParameter("txtName"));
                    ud.setPassword((String)request.getParameter("txtPass"));
                    UserDataDTO chk = (UserDataDTO)UserDataDAO.getInstance().loginCheck(ud);
                    if(chk.getUserID() != 0){
                        if(chk.getDeleteFlg() == 0){
                            //ログインに成功した場合ユーザーデータをセッションに保存
                            session.setAttribute("Login", "ll");
                            session.setAttribute("loginData", chk);
                            request.getRequestDispatcher(request.getParameter("beforeUrl")).forward(request, response);
                        }else{
                            //DeleteFlgが0でない場合リクエストパラメータに1を入れる
                            request.setAttribute("delFlg", "1");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                        }
                    }else{
                        //ユーザー名かパスワードに誤り
                        request.setAttribute("errFlg", "1");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                }
            }else{
                //ログアウト処理
                session.removeAttribute("Login");
                session.removeAttribute("loginData");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }catch(Exception e){
            out.println("error " + e.getMessage());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
