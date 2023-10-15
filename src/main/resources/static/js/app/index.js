const main = {
    init : function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.post_save();
        });
        $('#btn-update').on('click', function () {
            _this.post_update();
        });
        $('#btn-delete').on('click', function () {
            _this.post_delete();
        });
        $('#btn-comment-save').on('click', function () {
            _this.comment_save();
        });
        document.querySelectorAll('#btn-comment-update').forEach(function (item) {
            item.addEventListener('click', function () {
                const form = this.closest('form');
                _this.comment_update(form);
            });
        });
        $('[id^="btn-comment-delete-"]').on('click', function () {
               const commentId = this.id.split('-')[3];
               _this.comment_delete(commentId);
           });
    },
    post_save : function () {
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
    post_update : function () {
        const data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        const postId = $('#postId').val();

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
    post_delete : function () {
        const postId = $('#postId').val();

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
    comment_save : function () {
        const data = {
            postId: $('#postId').val(),
            content: $('#comment-content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/comments/' + data.postId,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('댓글이 등록되었습니다.');
            window.location.href = '/posts/' + data.postId;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    comment_update : function (form) {
        const data = {
            content: form.querySelector('#comment-content-update').value
        };

        const postId = form.querySelector('#postId').value;
        const commentId = form.querySelector('#commentId').value;

        $.ajax({
            type: 'PUT',
            url: '/api/comments/' + commentId,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('댓글이 수정되었습니다.');
            window.location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    comment_delete : function (commentId) {

        $.ajax({
            type: 'DELETE',
            url: '/api/comments/' + commentId,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('댓글이 삭제되었습니다.');
            window.location.reload();
        }).fail(function (jqXHR, textStatus, errorThrown) {
              console.log('Ajax request failed with status: ' + textStatus);
              console.log('Error: ' + errorThrown);
              console.log('Response Text: ' + jqXHR.responseText);
        });
    },
};

main.init();