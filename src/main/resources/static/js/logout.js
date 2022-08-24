function ajax_logout(){
    localStorage.setItem("token",null);
    window.location.href="http://localhost:8080/ds-sw/auth/login"
}