<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="memberInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看员工信息</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<div id="costBasicInfo">
					<div class="row">
						<div class="col-xs-3">
							< img src="images/user.png" style="width:200px;">
						</div>
						<div class="col-xs-8">
							<table class="table table-condensed" style="width:700px;">
								<tr>
									<td style="width:30%;"><strong>雇员姓名：</strong></td>
									<td><span id="name"></span></td>
								</tr>
								<tr>
									<td><strong>雇员职位：</strong></td>
									<td id="level"></td>
								</tr>
								<tr>
									<td><strong>所属部门：</strong></td>
									<td id="dept"></td>
								</tr>
								<tr>
									<td><strong>联系电话：</strong></td>
									<td id="phone"></td>
								</tr>
								<tr>
									<td><strong>备注信息：</strong></td>
									<td ><pre class="pre-scrollable" id="note" style="width:450px;height:150px;"></pre></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
