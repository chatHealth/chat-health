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




<!--  -->
<ul class="select2-selection__rendered">
<li class="select2-search select2-search--inline">
<input class="select2-search__field"
 type="search" tabindex="0" autocomplete="off" autocorrect="off" 
autocapitalize="none" spellcheck="false" role="searchbox" aria-autocomplete="list" placeholder="증상" style="width: 257.25px;">
</li></ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
		

			
<!--  -->

 <ul class="select2-selection__rendered">
 <li class="select2-selection__choice" title=" 면연력" data-select2-id="24">
 <span class="select2-selection__choice__remove" role="presentation">×</span> 면연력</li>
 <li class="select2-selection__choice" title=" 눈" data-select2-id="25">
 <span class="select2-selection__choice__remove" role="presentation">×</span> 눈</li>
 <li class="select2-search select2-search--inline">
 <input class="select2-search__field" 
 type="search" tabindex="0" autocomplete="off" autocorrect="off" autocapitalize="none" spellcheck="false" role="searchbox" 
 aria-autocomplete="list" placeholder="" style="width: 0.75em;"></li></ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>



<ul class="select2-selection__rendered">
<li class="select2-selection__choice" title=" 면연력" data-select2-id="24">
<span class="select2-selection__choice__remove" role="presentation">×</span> 면연력</li>
<li class="select2-selection__choice" title=" 눈" data-select2-id="25">
<span class="select2-selection__choice__remove" role="presentation">×</span> 눈</li>
<li class="select2-search select2-search--inline"><input class="select2-search__field" 
type="search" tabindex="0" autocomplete="off" autocorrect="off" autocapitalize="none" spellcheck="false" role="searchbox" 
aria-autocomplete="list" placeholder="" style="width: 0.75em;">
</li></ul>



		<ul class="select2-selection__rendered">
				<c:forEach items="${ selectedSymptomList }" var="symptom" varStatus="status">
						<li class="select2-selection__choice" title=" ${symptom}" data-select2-id="24">
 						<span class="select2-selection__choice__remove" role="presentation">×</span> ${symptom }</li>
				</c:forEach>
				</ul>
			
			
<!--  -->
<span
					class="select2 select2-container select2-container--bootstrap-5 select2-container--open select2-container--above select2-container--focus"
					dir="ltr" data-select2-id="1"><span class="selection"><span
						class="select2-selection select2-selection--multiple"
						role="combobox" aria-haspopup="true" aria-expanded="true"
						tabindex="-1" aria-disabled="false"
						aria-owns="select2-symptomOptions-results"
						aria-activedescendant="select2-symptomOptions-result-12ha-7">
						<ul class="select2-selection__rendered">
								<c:forEach items="${ selectedSymptomList }" var="symptom" varStatus="status">
						<li class="select2-selection__choice" title=" ${symptom}" data-select2-id="24">
 						<span class="select2-selection__choice__remove" role="presentation">×</span> ${symptom }</li>
				</c:forEach>
							</ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>	
				
