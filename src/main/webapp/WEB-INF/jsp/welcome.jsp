<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <style>
        .details {
            padding: 24px;
            background-color: lightblue;
        }

        .resultLinks{
            padding:24px;
        }

        form {
            padding: 24px;
        }
    </style>

</head>
<body>
<div class="details">
    <h1>Server side Details</h1>
    <p><strong>Hostname:</strong> ${hostname}</p>
</div>


<form method="post" class="blogPostForm" enctype="application/x-www-form-urlencoded">
    <div class="form-group">
        <label for="title">Title</label>
        <input type="text" name="title" class="form-control" id="title" placeholder="Title">
    </div>
    <div class="form-group">
        <label for="message">Message</label>
        <textarea name="message" class="form-control" id="message" rows="3"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<div class="resultLinks">
    <ul class="addData">
    </ul>
</div>


<script src="https://code.jquery.com/jquery-2.2.4.min.js"
        integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<script src="jquery.serializeObject.min.js"></script>

<script type="text/javascript">
    $(function () {

        $("form").submit(function (event) {
            $.ajax({
                type: "POST",
                url: "/blogPost",
                data: JSON.stringify($(this).serializeObject()),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    $(".addData").append("<li><a href='" + data._links.self.href + "' target='_blank'>" + data.title + "</a></li>");
                },
                failure: function (errMsg) {
                    alert(errMsg);
                }
            });
            event.preventDefault();
        });
    });
</script>

</body>
</html>