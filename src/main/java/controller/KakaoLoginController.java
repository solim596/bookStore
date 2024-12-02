/*
 * package controller;
 * 
 * import java.io.BufferedReader; import java.io.BufferedWriter; import
 * java.io.IOException; import java.io.InputStreamReader; import
 * java.io.OutputStreamWriter; import java.net.HttpURLConnection; import
 * java.net.URL;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.json.JSONObject;
 * 
 * @WebServlet("/BookStore/kakaoLogin.do") public class KakaoLoginController
 * extends HttpServlet { protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { String
 * code = request.getParameter("code");
 * 
 * // 인증 코드가 없을 경우 처리 if (code == null) { response.sendRedirect("login.jsp"); //
 * 로그인 페이지로 리다이렉트 return; }
 * 
 * // 액세스 토큰 요청을 위한 HTTP 요청 보내기 String accessToken = getAccessToken(code); if
 * (accessToken != null) { // 액세스 토큰으로 카카오 사용자 정보 요청
 * getKakaoUserInfo(accessToken, request, response); } else {
 * response.sendRedirect("login.jsp"); // 로그인 실패 시 } }
 * 
 * // 액세스 토큰 요청 private String getAccessToken(String code) throws IOException {
 * String apiUrl = "https://kauth.kakao.com/oauth/token"; URL url = new
 * URL(apiUrl); HttpURLConnection conn = (HttpURLConnection)
 * url.openConnection(); conn.setRequestMethod("POST"); conn.setDoOutput(true);
 * 
 * // POST 요청에 필요한 파라미터 String params = "grant_type=authorization_code" +
 * "&client_id=be9ebcf27dc0cdfc2038f88e5ee7c6e5" +
 * "&redirect_uri=http://localhost:8080/JSPBookShop/kakaoLogin.do" + "&code=" +
 * code;
 * 
 * // 요청 보내기 BufferedWriter bw = new BufferedWriter(new
 * OutputStreamWriter(conn.getOutputStream())); bw.write(params); bw.flush();
 * bw.close();
 * 
 * // 응답 받기 BufferedReader br = new BufferedReader(new
 * InputStreamReader(conn.getInputStream())); String responseLine; StringBuilder
 * responseBody = new StringBuilder(); while ((responseLine = br.readLine()) !=
 * null) { responseBody.append(responseLine); } br.close();
 * 
 * // JSON 파싱하여 액세스 토큰 추출 JSONObject jsonObject = new
 * JSONObject(responseBody.toString()); return
 * jsonObject.getString("access_token"); }
 * 
 * // 카카오 사용자 정보 요청 private void getKakaoUserInfo(String accessToken,
 * HttpServletRequest request, HttpServletResponse response) throws
 * ServletException, IOException { String apiUrl =
 * "https://kapi.kakao.com/v2/user/me"; URL url = new URL(apiUrl);
 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
 * conn.setRequestMethod("GET"); conn.setRequestProperty("Authorization",
 * "Bearer " + accessToken);
 * 
 * // 응답 받기 BufferedReader br = new BufferedReader(new
 * InputStreamReader(conn.getInputStream())); String responseLine; StringBuilder
 * responseBody = new StringBuilder(); while ((responseLine = br.readLine()) !=
 * null) { responseBody.append(responseLine); } br.close();
 * 
 * // JSON 파싱 JSONObject jsonObject = new JSONObject(responseBody.toString());
 * // "id" 값을 Long 타입으로 가져옴 long kakaoId = jsonObject.getLong("id"); // 여기서
 * getJSONObject -> getLong으로 수정
 * 
 * 
 * // 세션에 사용자 정보 저장 HttpSession session = request.getSession();
 * session.setAttribute("userID", kakaoId); session.setAttribute("loginType",
 * "kakao"); //세션 내장객체에서 prevPage속성값을 가져와서 prevPage변수에 저장 String prevPage =
 * (String) session.getAttribute("prevPage"); //만약 prevPage가 null이 아니라면
 * prevPage속성값을 제거하고, //prevPage로 이동 if(prevPage != null) {
 * session.removeAttribute("prevPage"); response.sendRedirect(prevPage);
 * //prevPage값이 null이면 index페이지로 이동 }else { response.sendRedirect("index.jsp");
 * } } }
 * 
 */