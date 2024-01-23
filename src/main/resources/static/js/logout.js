function ajax_logout(){
    localStorage.setItem("token",null);
    window.location.href="http://ec2-15-165-161-6.ap-northeast-2.compute.amazonaws.com:8080/ds-sw/auth/login"
    alert("로그아웃 되었습니다!");
}