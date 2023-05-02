// login

let login_form = {
    init:function(){
        $("#login_btn").click(function(){
            login_form.send();
        });
    },
    send:function(){
        $("#login_form").attr({
            'action':'/loginimpl',
            'method':'post'
        });
        $("#login_form").submit();
    }
};


// jsp01

let jsp01 = {
    data:0,
    init:function(num){
        this.data = num;
        // this.data = '<c:out value="${num}"/>';
        this.display();
    },
    display:function(){
        $('#jsp01').text(this.data+'');
    }
};

$(function(){
    jsp01.init();
});