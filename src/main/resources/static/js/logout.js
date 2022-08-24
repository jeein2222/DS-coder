function ajax_logout(){
    localStorage.setItem("token",null);
    window.location.href="http://localhost:8080/ds-sw/auth/login"
    alert("로그아웃 되었습니다!");
}