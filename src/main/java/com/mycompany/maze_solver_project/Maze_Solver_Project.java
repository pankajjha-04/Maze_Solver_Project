/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver_project;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Panka
 */
public class Maze_Solver_Project extends JFrame{
    
    private int[][] maze = 
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},           
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
        
    };
    
    /* The maze array is a 2D array of integers, 
       where 0 represents an empty cell, 1 represents a wall, 
       and 9 represents the destination cell. 
       The path list stores the indexes of the cells that
       form the solution path.*/
    
    public List<Integer> path = new ArrayList<>();
    public Maze_Solver_Project(){
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze, 1,1, path);
        //System.out.println(path);
        
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        
        for(int i = 0;i<maze.length;i++){
            for(int j = 0; j<maze[0].length;j++){
                Color color;
                switch(maze[i][j]){
                    case 1 : color = Color.BLACK; break;
                    case 9 : color= Color.RED; break;
                    default : color = Color.WHITE;break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
                
            }
        }
        
        for(int i = 0;i<path.size();i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            
            System.out.println("X coordinates " + pathx);
            System.out.println("Y coordinates " + pathy);
            
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx, 30*pathy, 20, 20);
            
        }
        
    }
    public static void main(String[] args){
        Maze_Solver_Project view = new Maze_Solver_Project();
        view.setVisible(true);
    }
    
}   

