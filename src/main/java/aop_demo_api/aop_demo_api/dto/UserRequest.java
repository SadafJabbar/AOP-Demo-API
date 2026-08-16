package aop_demo_api.aop_demo_api.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserRequest(

        @NotBlank(message = "name cannot be blank")
        @Size(min = 2,max = 30,message = "name must be between 2 to 30 characters")
        String name,

        @Email
        @NotBlank(message = "please enter a valid email address")
        String email,

        @NotNull(message = "age cant be null")
        int age
) {
}
