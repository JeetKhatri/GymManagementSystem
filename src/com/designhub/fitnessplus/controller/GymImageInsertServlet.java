package com.designhub.fitnessplus.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.designhub.fitnessplus.bean.GymDetailsBean;
import com.designhub.fitnessplus.bean.GymImageBean;
import com.designhub.fitnessplus.dao.GymDetailsDAO;
import com.designhub.fitnessplus.dao.GymImageDAO;

public class GymImageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String filePath = getServletContext().getInitParameter("file-upload");

		FileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> items = null;

		String fieldName = null;
		String fieldValue = null;

		String fileName = null;

		File file = null;

		Boolean isError = false;
		GymImageBean gymImageBean = new GymImageBean();

		try 
		{
			
			items = upload.parseRequest(request);
			
			for(int i=0;i<items.size();i++)
			{
				FileItem item = items.get(i);
				
				if(item.isFormField())
				{
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					System.out.println("Name " + fieldName);
					System.out.println("Value " + fieldValue);
					
					if (fieldName.equalsIgnoreCase("selGymName")) {
						String value = fieldValue;
						gymImageBean.setGymDetailsId(value);
					}
					
					
				}
				else
				{
					
					fieldName = item.getFieldName();
					System.out.println("FieldName : "+fieldName);
					fileName = item.getName();
					System.out.println("File Name : "+fileName);
					ServletContext context = getServletContext();
					file = new File(filePath + File.separator
							+ fileName);
					try
					{
						if(fileName.isEmpty())
						{
							System.out.println("Error");
							
							request.setAttribute(
									"photo",
									"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
							
						}
						else
						{
							System.out.println("MIME : "+context.getMimeType(fileName));
							if(context.getMimeType(fileName).equals("image/gif")
							|| context.getMimeType(fileName).equals("image/jpeg")
							|| context.getMimeType(fileName).equals("image/png"))
							{
								item.write(file);
								System.out.println("===> "+file.getName());
								gymImageBean.setGymImagePath(file.getName());
								System.out.println("Success");
								request.setAttribute("photo",file.getPath());
								System.out.println(file.getPath());
								
							}
							else
							{
								request.setAttribute(
										"photo",
										"<font color=red>*Please upload files that end in types .png,.jpeg only.</font>");
								request.getRequestDispatcher("student.jsp").forward(request, response);
							}
						}
					}
					catch(Exception e)
					{
						
					}
					
					
				}
			}
			
			if( new GymImageDAO().insert(gymImageBean))
			{
				
				request.getRequestDispatcher("GymImageListServlet").forward(request, response);
				System.out.println("Success......");
			}
			else
			{
				System.out.println("Failll......");
			}
			
		} 
		catch (FileUploadException e)
		{
			e.printStackTrace();
		}
	}

}
