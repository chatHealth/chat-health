<%@ include file="../include/nav.jsp"%>

<!-- search res 경로띄우기 -->
<div class="container my-5">
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb breadcrumb-chevron p-3 bg-body-tertiary rounded-3">
      <li class="breadcrumb-item">
        <a class="link-body-emphasis" href="#">
          <svg class="bi" width="16" height="16"><use xlink:href="#house-door-fill"></use></svg>
          <span class="visually-hidden">Home</span>
        </a>
      </li>
      <li class="breadcrumb-item">
        <a class="link-body-emphasis fw-semibold text-decoration-none" href="#">Library</a>
      </li>
      <li class="breadcrumb-item active" aria-current="page">
        Data
      </li>
    </ol>
  </nav>
</div>

<!--  main  -->
<div class="row align-items-center py-3 px-xl-5">
	<div class=" d-none d-lg-block">
		<a href="" class="text-decoration-none">
			<h1 class="m-0 display-5 font-weight-semi-bold main-logo-chat-health">
				chat-health
			</h1>
		</a>
	</div>
	
	<div class="col-lg-6 col-6 text-left">
		<form action="../category/list">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for products">
				<div class="input-group-append">
					<span class="input-group-text bg-transparent text-primary">
						<i class="fa fa-search"></i>
					</span>
				</div>
			</div>
		</form>
	</div>
	
	<div class="col-lg-3 col-6 text-right">
		<a href="" class="btn border"> <i class="fas fa-heart text-primary"></i> <span class="badge">0</span> </a> 
		<a href="" class="btn border"> <i class="fas fa-shopping-cart text-primary"></i> <span class="badge">0</span> </a>
	</div>
</div>



<table class="table">
				<tbody>
					<tr>
						<td><button type="button" class="btn btn-outline-primary">Left</button></td>
						<td>Otto</td>
						<td>@mdo</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Jacob</td>
						<td>Thornton</td>
						<td>@fat</td>e
					</tr>

				</tbody>
			</table>








