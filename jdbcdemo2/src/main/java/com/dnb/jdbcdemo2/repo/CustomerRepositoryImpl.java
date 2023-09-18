//package com.dnb.jdbcdemo2.repo;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.dnb.jdbcdemo2.dto.Account;
//import com.dnb.jdbcdemo2.dto.Customer;
//import com.dnb.jdbcdemo2.utils.DBUtils;
//@Repository
//public class CustomerRepositoryImpl implements CustomerRepository {
//	@Autowired
//	private DBUtils dbUtils;
//	@Override
//	public Customer createCustomer(Customer customer) {
//		Optional<Connection> connection = dbUtils.getConnection();
//		String createCustomerStatement = "insert into customer "
//				+ "(customerId, CustomerName, CustomercontactNumber, Customeraddress, CustomerUUID,CustomerPAN)"
//				+ " values(?,?,?,?,?,?,)";
//		PreparedStatement preparedStatement = null;
//		if (connection.isPresent()) {
//			try {
//				preparedStatement = connection.get().prepareStatement(createCustomerStatement);
//				preparedStatement.setInt(1, customer.getCustomerId());
//				preparedStatement.setString(2, customer.getCustomerName());
//				preparedStatement.setString(3, customer.getCustomercontactNumber());
//				preparedStatement.setString(4, customer.getCustomeraddress());
//				preparedStatement.setString(5,customer.getCustomerUUID());
//				preparedStatement.setString(6, customer.getCustomeraddress());
//				int result = preparedStatement.executeUpdate(); // DML
//				if (result > 0) {
//					return customer;//it should return the actual account object from DB.
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally {
//				if(connection.isPresent()) {
//					dbUtils.closeConnection(connection.get());
//				}
//				
//			}
//		} else
//			return null;
//		return customer;
//		
//	}
//	public Optional<Customer> getCustomerById(int CustomerId) {
//		// TODO Auto-generated method stub
//		Optional<Connection> connection = dbUtils.getConnection();
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		String query = "SELECT * FROM customer WHERE customerId = ?";
//		if (connection.isPresent()) {
//			try {
//				preparedStatement = connection.get().prepareStatement(query);
//				preparedStatement.setInt(1, CustomerId);
//				resultSet = preparedStatement.executeQuery();
//				if(resultSet.next()) {
//					Customer customer = new Customer();
//					customer.setCustomerId(resultSet.getInt("CustomerId"));
//					customer.setCustomerName(resultSet.getString("CustomerName"));
//					customer.setCustomercontactNumber(resultSet.getString("CustomercontactNumber"));
//					customer.setCustomeraddress(resultSet.getString("Customeraddress"));
//					customer.setCustomerUUID(resultSet.getString("CustomerUUID"));
//					customer.setCustomerPAN(resultSet.getString("CustomerPAN"));
//					
//					
//					return Optional.of(customer);
//					
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally {
//				if(connection.isPresent()) {
//					dbUtils.closeConnection(connection.get());
//				}
//				
//			}
//		} else
//			return null;
//		return Optional.empty();
//	
//	}
//
//	public boolean deleteCustomerById(int CustomerId) {
//		// TODO Auto-generated method stub
//		Optional<Connection> connection = dbUtils.getConnection();
//		PreparedStatement preparedStatement = null;
//		String query = "DELETE FROM account WHERE CustomerId = ?";
//		if(connection.isPresent()) {
//			try {
//				preparedStatement = connection.get().prepareStatement(query);
//				preparedStatement.setFloat(1, CustomerId);
//				int result = preparedStatement.executeUpdate();
//				if(result == 0)
//					return false;
//				else
//					return true;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				if(connection.isPresent()) {
//					dbUtils.closeConnection(connection.get());
//				}
//			
//		}
//		
//		
//	}
//		return false;
//	}
//
//	@Override
//	public List<Customer> getAllCustomers() {
//		// TODO Auto-generated method stub
//		Optional<Connection> connection = dbUtils.getConnection();
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		String query = "SELECT * FROM customer";
//		List<Customer> customers = new ArrayList<>();
//		if (connection.isPresent()) {
//			try {
//				preparedStatement = connection.get().prepareStatement(query);
//				resultSet = preparedStatement.executeQuery();
//				if(resultSet.next()) {
//					Customer customer = new Customer();
//					customer.setCustomerId(resultSet.getInt("CustomerId"));
//					customer.setCustomerName(resultSet.getString("CustomerName"));
//					customer.setCustomercontactNumber(resultSet.getString("CustomercontactNumber"));
//					customer.setCustomeraddress(resultSet.getString("Customeraddress"));
//					customer.setCustomerUUID(resultSet.getString("CustomerUUID"));
//					customer.setCustomerPAN(resultSet.getString("CustomerPAN"));
//					
//					
//				}
//				return customers;
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally {
//				if(connection.isPresent()) {
//					dbUtils.closeConnection(connection.get());
//				}
//				
//			}
//		} else
//			return null;
//		return null;
//		
//	}
//
//	@Override
//	public boolean deleteAccountById(String customerId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//
//}
