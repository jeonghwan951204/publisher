package com.book.publisher.api;

import com.book.publisher.entity.Address;
import com.book.publisher.entity.Member;
import com.book.publisher.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"회원 API"})
public class MemberApiController {

    private final MemberService memberService;

    @ApiOperation(value = "회원목록 전체조회")
    @GetMapping("/members")
    public ResponseEntity getMembers(){
        List<Member> members = memberService.getMembers();

        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @PostMapping("/members")
    public ResponseEntity postMember(@RequestBody @Valid Member member, BindingResult result){
        Member joinMember = memberService.join(member);

        return ResponseEntity.status(HttpStatus.CREATED).body(joinMember);
    }

    @PutMapping("/members/{id}")
    public ResponseEntity putMember(@PathVariable("id") Long id,
                                    @RequestBody @Valid UpdateMemberRequest request,
                                    BindingResult result)
    {
        Member member = Member.builder()
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .build();

        Member updateMember = memberService.updateMember(id, member);

        return ResponseEntity.status(HttpStatus.CREATED).body(updateMember);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity deleteMember(@PathVariable("id") Long id){
        memberService.deleteMember(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Data
    static class UpdateMemberRequest{
        private String email;
        private String phoneNumber;
        private Address address;
    }
}
