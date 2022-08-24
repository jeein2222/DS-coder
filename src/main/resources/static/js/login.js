
function ajax_login(frm){ //로그인
    const formData=$("#login_info").serializeObject();
    console.log(formData);
    $.ajax({
        url:'/ds-sw/auth/signin',
        type:'POST',
        contentType:'application/json',
        data:JSON.stringify(formData),
        success:function(data){
            console.log(data.token);
            localStorage.setItem("token",data.token);
            window.location.href = 'http://localhost:8080/ds-sw/';
            alert("로그인 성공!");
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    return false;
}

