<!-- Page util -->
<%@ page contentType="text/html;charset=UTF-8"%>
<style>
	.am-pagination .am-disabled{display: none;}
</style>
<div class="am-pagination-tip">Page: ${page.pageNo+1}/${page.pageNumber} ,Total : ${page.total}</div>
<c:if test="${page.total>page.pageSize}">
<ul class="am-pagination tpl-pagination am-pagination-right" style="margin:0;">
	<li class="<c:if test="${page.hasFirstPage}">am-disabled</c:if>"><a href="javascript:page(${page.first});"><i class="am-icon-fast-backward"></i></a></li>
	<li class="<c:if test="${page.hasFirstPage}">am-disabled</c:if>"><a href="javascript:page(${page.prev});"><i class="am-icon-backward"></i></a></li>
	<li class="<c:if test="${page.hasLastPage}">am-disabled</c:if>"><a href="javascript:page(${page.next});"><i class="am-icon-forward"></i></a></li>
	<li class="<c:if test="${page.hasLastPage}">am-disabled</c:if>"><a href="javascript:page(${page.last});"><i class="am-icon-fast-forward"></i></a></li>
</ul>
<script type="text/javascript">
     //Paging query
     function page(n){
		$("#pageNo").val(n);
		$("#searchForm").submit();
     	return false;
     }

	//Sorting method
	function order(by){
		var orderBy = $("#orderBy").val();
		if(orderBy.indexOf(by)>-1){
			//Oder rule
			if(orderBy.indexOf("desc")>-1){
				$("#orderBy").val(by+" asc");
			}else{
				$("#orderBy").val(by+" desc");
			}
		}else{
			//First time to enter
			$("#orderBy").val(by+" desc");
		}
		$("#pageNo").val(0);
		$("#searchForm").submit();
		return false;
	}
</script>
</c:if>