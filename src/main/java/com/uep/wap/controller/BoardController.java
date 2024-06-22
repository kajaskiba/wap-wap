package com.uep.wap.controller;

import com.uep.wap.dto.BoardDTO;
import com.uep.wap.model.Board;
import com.uep.wap.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping(path = "/boards")
    public String addBoard(@RequestBody BoardDTO boardDTO) {
        boardService.addBoard(boardDTO);
        return "Board added successfully hehehe";
    }

    @PutMapping(path = "/boards/{board_id}")
    public String editBoard(@PathVariable int board_id, @RequestBody BoardDTO boardDTO) {
        boardService.editBoard(board_id, boardDTO);
        return "Board edited!";
    }

    @GetMapping(path = "/boards")
    public Iterable<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping(path = "/boards/{id}")
    public Optional<Board> getBoardById(@PathVariable int id) {
        return boardService.getBoardById(id);
    }

    @DeleteMapping(path = "/boards/{id}")
    public String deleteBoardById(@PathVariable int id) {
        boardService.deleteBoardById(id);
        return "Board deleted!!!!";
    }

    @GetMapping(path = "/boards/{title}")
    public Board findBoardByTitle(@PathVariable String title) {
        return boardService.findBoardByTitle(title);
    }

    @GetMapping(path = "/boards/{ownerId}")
    public Board findBoardByOwnerId(@PathVariable int ownerId) {
        return boardService.findBoardByOwnerID(ownerId);
    }


    }

