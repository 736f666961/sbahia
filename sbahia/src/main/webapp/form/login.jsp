<div class="login-container">
	<div class="login">
		<h1 style="text-align:center">Login</h1>
		
        <form action="/sbahia/login" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">Email</label> <br/>
            <input style="padding: 12px;width: 100%" type="text" class="form-control" id="exampleInputEmail1" autocomplete="off" aria-describedby="emailHelp" placeholder="Enter your email" name="email">
          </div>

          <div class="form-group" style="margin-top:8px">
            <label for="exampleInputEmail1">Password</label> <br/>
            <input style="padding: 12px;width: 100%" type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter your password" name="password">
          </div>

          <button style="padding: 12px;width: 104%;margin-top:12px" type="submit" class="btn btn-dark btn-block mt-2">Login</button>
        </form>
	</div>  
</div>