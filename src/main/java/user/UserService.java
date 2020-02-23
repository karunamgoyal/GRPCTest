package user;

import io.grpc.stub.StreamObserver;
import org.example.grpc.User;
import org.example.grpc.userGrpc.userImplBase;

public class UserService extends userImplBase{
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside Login");
        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(username.equals(password)) {
            System.out.println(username + "   " + password);
            response.setResponseCode(201).setResponseMessage("SUCCESS");
        }
        else{
            response.setResponseCode(501).setResponseMessage("FAILURE");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Logout");
    }
}
