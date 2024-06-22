package com.uep.wap.service;

import com.uep.wap.dto.BoardDTO;
import com.uep.wap.model.Board;
import com.uep.wap.model.Category;
import com.uep.wap.model.Photo;
import com.uep.wap.model.User;
import com.uep.wap.repository.BoardRepository;
import com.uep.wap.repository.CategoryRepository;
import com.uep.wap.repository.PhotoRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private UserRepository userRepository;

    public void addBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setOwnerID(boardDTO.getOwnerID());
        board.setTitle(boardDTO.getTitle());
        board.setDescription(boardDTO.getDescription());


        List<Category> categories = new ArrayList<>();
        if (!boardDTO.getCategoryName().isEmpty()){
            Category category = categoryRepository.findByName(boardDTO.getCategoryName());
            categories.add(category);
            board.setCategories(categories);
        }


        List<Photo> photos = new ArrayList<>();
        if(boardDTO.getPhotoID() != 0){
            Photo photo = photoRepository.findById(boardDTO.getPhotoID()).get();
            photos.add(photo);
            board.setPhotos(photos);
        }

        if(!boardDTO.getCategoryName().isEmpty()) {
            User user = userRepository.findByUsername(boardDTO.getUsername());
            board.setUsers(user);
        }

        boardRepository.save(board);
    }

    public void editBoard(int board_id, BoardDTO boardDTO) {
        Board board = boardRepository.findById(board_id).get();
        board.setOwnerID(boardDTO.getOwnerID());
        board.setTitle(boardDTO.getTitle());
        board.setDescription(boardDTO.getDescription());


        List<Category> categories = new ArrayList<>();
        if (!boardDTO.getCategoryName().isEmpty()){
            Category category = categoryRepository.findByName(boardDTO.getCategoryName());
            categories.add(category);
            board.setCategories(categories);
        }


        List<Photo> photos = new ArrayList<>();
        if(boardDTO.getPhotoID() != 0){
            Photo photo = photoRepository.findById(boardDTO.getPhotoID()).get();
            photos.add(photo);
            board.setPhotos(photos);
        }

        if(!boardDTO.getCategoryName().isEmpty()) {
            User user = userRepository.findByUsername(boardDTO.getUsername());
            board.setUsers(user);
        }

        boardRepository.save(board);
    }

    public Iterable<Board> getAllBoards() {return boardRepository.findAll();}
    public Optional<Board> getBoardById(int id) {return boardRepository.findById(id);}
    public void deleteBoardById(int id) {boardRepository.deleteById(id);}
    public Board findBoardByTitle(String title) {return boardRepository.findByTitle(title);}
    public Board findBoardByOwnerID(int ownerID) {return boardRepository.findByOwnerID(ownerID);}

}
