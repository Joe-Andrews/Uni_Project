<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="projectLoginCSS.css">
	

</head>
<body>
    <div class="container">
        <h1>Login to Totalitea</h1>
        <p class="instructions">Please fill in your details below.</p>
		<p class="instructions">Don't have an account? <a href="projectRegister.html">Register here</a>.</p>
        
        <form action= "LoginPage" method="POST">
            <!-- Name Field -->
            <div class="mb-3">
                <label for="email" class="form-label">Email address:</label>
                <input type="email" class="form-control" name="email" placeholder="Enter your email">
            </div>

            <!-- Email Field -->
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
            </div>
			
            <!-- Submit Button -->
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
<script src = "https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js">
</script>
</body>
</html>