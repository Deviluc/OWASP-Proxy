package org.owasp.proxy.model;


public class ConversationSummary {

	private long id;

	private String host, requestMethod, requestResource, requestContentType,
			responseStatus, responseReason, responseContentType, connection;

	private boolean ssl;

	private int port, requestContentSize, responseContentSize;

	private long requestTime, responseHeaderTime, responseContentTime;

	public ConversationSummary() {}
	
	public ConversationSummary(Conversation conversation)
			throws MessageFormatException {
		id = conversation.getId();
		requestTime = conversation.getRequestTime();
		responseHeaderTime = conversation.getResponseHeaderTime();
		responseContentTime = conversation.getResponseContentTime();
		connection = conversation.getConnection();
		
		summarizeRequest(conversation.getRequest());
		summarizeResponse(conversation.getResponse());
	}

	public void summarizeRequest(Request request) throws MessageFormatException {
		host = request.getHost();
		port = request.getPort();
		ssl = request.isSsl();

		requestMethod = request.getMethod();
		requestResource = request.getResource();
		requestContentType = request.getHeader("Content-Type");
		byte[] content = request.getContent();
		requestContentSize = content == null ? 0 : content.length;
	}
	
	public void summarizeResponse(Response response) throws MessageFormatException {
		responseStatus = response.getStatus();
		responseReason = response.getReason();
		responseContentType = response.getHeader("Content-Type");
		byte[] content = response.getContent();
		responseContentSize = content == null ? 0 : content.length;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestResource() {
		return requestResource;
	}

	public void setRequestResource(String requestResource) {
		this.requestResource = requestResource;
	}

	public String getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(String requestContentType) {
		this.requestContentType = requestContentType;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseReason() {
		return responseReason;
	}

	public void setResponseReason(String responseReason) {
		this.responseReason = responseReason;
	}

	public String getResponseContentType() {
		return responseContentType;
	}

	public void setResponseContentType(String responseContentType) {
		this.responseContentType = responseContentType;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getRequestContentSize() {
		return requestContentSize;
	}

	public void setRequestContentSize(int requestContentSize) {
		this.requestContentSize = requestContentSize;
	}

	public int getResponseContentSize() {
		return responseContentSize;
	}

	public void setResponseContentSize(int responseContentSize) {
		this.responseContentSize = responseContentSize;
	}

	public long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

	public long getResponseHeaderTime() {
		return responseHeaderTime;
	}

	public void setResponseHeaderTime(long responseHeaderTime) {
		this.responseHeaderTime = responseHeaderTime;
	}

	public long getResponseContentTime() {
		return responseContentTime;
	}

	public void setResponseContentTime(long responseContentTime) {
		this.responseContentTime = responseContentTime;
	}

}