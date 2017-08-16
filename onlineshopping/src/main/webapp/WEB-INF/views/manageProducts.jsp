<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">



		<c:if test="${not empty message }">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button id="closeManageAlert" type="button" onclose=""
						class="close" data-dismiss="alert">&times;</button>
					${message }
				</div>
			</div>
		</c:if>




		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">

					<!-- FORM Elements -->

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot }/manage/products" method="post"
						enctype="multipart/form-data">


						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Product Name : </label>
							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Brand Name : </label>
							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em"></sf:errors>

							</div>

						</div>

						<!-- Product Description . TEXTAREA -->
						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Product
								Description : </label>
							<div class="col-md-8">

								<sf:textarea rows="4" path="description" id="description"
									placeholder="Enter Product Description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em"></sf:errors>
							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Unit Price : </label>
							<div class="col-md-8">

								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"></sf:errors>
							</div>

						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Quantity
								Available : </label>
							<div class="col-md-8">

								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity" class="form-control" />

							</div>

						</div>

						<!-- File element for Image -->
						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Select
								an Image : </label>
							<div class="col-md-8">

								<sf:input type="file" path="file" id="file"
									class="form-control fileInputBox" />
								<sf:errors path="file" cssClass="help-block" element="em"></sf:errors>
							</div>

						</div>



						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Select
								Category : </label>

							<div class="col-md-8">

								<!-- items are coming from controller @link ManagementController -->
								<!-- itemLabel is the text which i want to show -->
								<!-- itemValue is the value which value i want to use on select -->
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id">
								</sf:select>
							</div>

						</div>

						<!-- Submit -->
						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">

								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary">
								<!-- Hidden Fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								<sf:hidden path="active" />
							</div>

						</div>

					</sf:form>

				</div>
			</div>
		</div>

	</div>

</div>