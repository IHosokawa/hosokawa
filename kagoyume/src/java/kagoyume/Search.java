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
import net.arnx.jsonic.JSON;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author You
 */
public class Search extends HttpServlet {

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
        //リクエストパラメータの文字コードをUTF-8に変更
        request.setCharacterEncoding("UTF-8");
    /**
     * Yahoo!ディベロッパーのAPP ID
     */
    String APP_ID = "dj0zaiZpPUNXM3RheG1KSW9GTyZzPWNvbnN1bWVyc2VjcmV0Jng9Mjk-";

    /** 
     * Yahoo!ショッピングAPIのベースURI
     */
    String BASE_URI = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    
    //セッションの開始
    HttpSession session = request.getSession();
        try {
            //
            if(request.getParameter("keyword") != null && 
                    request.getParameter("ReSearch") == null){
            
                //入力されたデータを変数へ
                String keyword = (String)request.getParameter("keyword");
                if(keyword != null){
                    //入力データをURLエンコード
                    String encodeKeyword = URLEncoder.encode(keyword, "UTF-8");
                    //URLの生成
                    URL url = new URL(BASE_URI + "?appid=" + APP_ID + "&query=" + encodeKeyword);
                    //APIへアクセス
                    HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
                    urlcon.setRequestMethod("GET");
                    urlcon.setInstanceFollowRedirects(false);
                    urlcon.connect();

                    //APIからデータを呼び出す
                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
                    StringBuffer responseBuffer = new StringBuffer();
                    while(true){
                        String line = reader.readLine();
                        if( line == null ){
                            break;
                        }
                        responseBuffer.append(line);
                    }
                    reader.close();
                    urlcon.disconnect();

                    //呼び出したJSON形式のデータを保存
                    String jsonText = responseBuffer.toString();

                    //parse(keyword, responseS);
                    //JSON形式のデータをMAP形式にデコード
                    Map<String, Map<String, Object>> json = JSON.decode(jsonText);
                    //複数検索用のArrayList変数
                    ArrayList<SearchData> searchData = new ArrayList<SearchData>();
                    //検索件数を変数へ格納
                    String sum = (String)json.get("ResultSet").get("totalResultsReturned").toString();
                    SearchData sd = new SearchData();
                    sd.setSearchName(keyword);
                    sd.setSearchSum(sum);
                    //検索キーワードと検索件数をセッションに保存
                    session.setAttribute("SearchData", sd);
                    //
                    for(int i = 0; i < Integer.parseInt(sum) ;i++){
                        if( !Integer.valueOf((String) json.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
                            @SuppressWarnings("unchecked")
                            //「i」件目のアドレスを変数へ格納
                            Map<String, Object> result =
                                    ((Map<String, Object>) ((Map<String, Map<String, Object>>)json
                                            .get("ResultSet").get("0"))
                                            .get("Result").get(String.valueOf(i)));

                            String name = result.get("Name").toString();
                            @SuppressWarnings("unchecked")
                            String uri = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
                            @SuppressWarnings("unchecked")
                            String price = ((Map<String, Object>)result.get("PriceLabel")).get("DefaultPrice").toString();
                            @SuppressWarnings("unchecked")
                                    String itemCode = result.get("Code").toString();
                            @SuppressWarnings("unchecked")
                                    String description = result.get("Description").toString();
                            @SuppressWarnings("unchecked")
                                    String reviewRate = ((Map<String, Object>)result.get("Review")).get("Rate").toString();
                            @SuppressWarnings("unchecked")
                                    String reviewCount =((Map<String, Object>)result.get("Review")).get("Count").toString();

                            SearchData resultData = new SearchData();
                            resultData.setName(name);
                            resultData.setUri(uri);
                            resultData.setPrice(price);
                            resultData.setItemCode(itemCode);
                            resultData.setDescription(description);
                            resultData.setReviewRate(reviewRate);
                            resultData.setReviewCount(reviewCount);

                            //1件のデータをArrayListに格納
                            searchData.add(resultData);
                        }
                    }
                    //検索結果の格納されたArrayListをセッションへ保存
                    session.setAttribute("ResultData", searchData);

                }
            }
            session.setAttribute("Coming", "search");
            request.getRequestDispatcher("/search.jsp").forward(request, response);
            
        } catch (Exception e){
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
