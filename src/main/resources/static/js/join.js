function ajax_join(frm){ //회원가입
    const formData=$("#user_info").serializeObject();
    console.log(formData);
    $.ajax({
        url:'/ds-sw/auth/signup',
        type:'POST',
        contentType:'application/json',
        data:JSON.stringify(formData),
        success:function(data){
            console.log(data.data);
            window.location.href = 'http://ec2-15-165-161-6.ap-northeast-2.compute.amazonaws.com:8080/ds-sw/auth/login';
            alert("회원가입 성공!");
        },error:function(xhr,status,error){
            console.log("["+xhr.status+"]"+error);
        }
    });
    return false;
}