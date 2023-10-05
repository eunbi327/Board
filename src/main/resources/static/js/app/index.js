const main = {
    init : function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        $('#btn-register').on('click', function () {
            _this.register();
        })
    },
    save : function () {
        const data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('게시글이 등록되었습니다.');
            window.location.href = '/'; // 게시글 등록 성공시 메인페이지로 이동
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        const data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        const postId = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/posts/' + postId,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('게시글이 수정되었습니다.');
            window.location.href = '/'; // 게시글 수정 성공시 메인페이지로 이동
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        const postId = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/posts/' + postId,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('게시글이 삭제되었습니다.');
            window.location.href = '/'; // 게시글 삭제 성공시 메인페이지로 이동
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    register : function () {
        const email = $('#email').val();
        const nickname = $('#name').val();
        const password = $('#password').val();
        const confirmPassword = $('#confirmPassword').val();

        const data = {
            email: email,
            nickname: nickname,
            password: password,
            confirmPassword: confirmPassword
        };

        $.ajax({
            type: 'POST',
            url: '/api/members/',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();