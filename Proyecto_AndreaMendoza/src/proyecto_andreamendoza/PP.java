package proyecto_andreamendoza;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PP extends javax.swing.JFrame {

    static ArrayList<Usuario> Users = new ArrayList();
    static ArrayList<String> UNs = new ArrayList();
    Usuario USER = new Usuario();

    public PP() {
        this.Recycle = new ArrayList();
        initComponents();
        LogIn.setVisible(true);
        LogIn.setLocationRelativeTo(null);
        CurrentDateTime();
        UNs.add("andreaj");
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        agenda.setDefaultRenderer(String.class, centerRenderer);
        Sistema = new File("./Sistema");
        Sistema.mkdir();
        TimeThread t = new TimeThread(Time);
        Thread t2 = new Thread(t);
        t2.start();
        bm = new BarMusic(MusicPB);
        CodeWords.add("mkdir");
        CodeWords.add("rm");
        CodeWords.add("cd");
        CodeWords.add("cd...");
        CodeWords.add("dir");
        CodeWords.add("date");
        CodeWords.add("time");
        CodeWords.add("help");
        DefaultTreeModel m = (DefaultTreeModel) TreeArchives.getModel();
        DefaultMutableTreeNode Root = (DefaultMutableTreeNode) m.getRoot();
        SetTrees(new File("./Sistema/"), Root);
        txt.setContentType("text/html");

    }

    private void CurrentDateTime() {
        Calendar cal = new GregorianCalendar();
        Date Fecha = new Date();
        Fecha.setDate(cal.get(cal.DAY_OF_MONTH));
        Fecha.setMonth(cal.get(cal.MONTH));
        Fecha.setYear(cal.get((cal.YEAR)));
        DateFormat f = new SimpleDateFormat("dd/MM/YY");
        Date.setText(f.format(Fecha));
    }

    private void SetTrees(File Root, DefaultMutableTreeNode nodo) {
        try {
            for (File temp : Root.listFiles()) {
                if (temp.isFile()) {
                    DefaultMutableTreeNode n = new DefaultMutableTreeNode(temp.getName());
                    nodo.add(n);
                    PathsNodes.add(temp.getPath());
                } else {
                    DefaultMutableTreeNode n = new DefaultMutableTreeNode(temp.getName());
                    nodo.add(n);
                    PathsNodes.add(temp.getPath());
                    SetTrees(temp, n);
                }
            }
        } catch (Exception e) {
        }
    }

    static private void CreateSubDirs(String Name) {
        // BasicFileAttributes f;
        File f = new File("./Sistema/" + Name);
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mis Imágenes");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mis Documentos");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mi Música");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mi Calendario");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mis Mensajes");
        f.mkdir();
        f = new File("./Sistema/" + Name + "/Mi Correo");
        f.mkdir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogIn = new javax.swing.JFrame();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jt_userlogin = new javax.swing.JTextField();
        pf_pwlogin = new javax.swing.JPasswordField();
        b_login = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();
        b_shutdown = new javax.swing.JButton();
        jb_forgotpw = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        PopUpMain = new javax.swing.JPopupMenu();
        m_changebg1 = new javax.swing.JMenuItem();
        m_changecolor1 = new javax.swing.JMenuItem();
        m_help = new javax.swing.JMenuItem();
        NewUser = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        tf_newuname = new javax.swing.JTextField();
        tf_newunuser = new javax.swing.JTextField();
        tf_newuemail = new javax.swing.JTextField();
        tf_newunpw = new javax.swing.JPasswordField();
        jd_newbday = new com.toedter.calendar.JDateChooser();
        s_edad = new javax.swing.JSpinner();
        cb_question = new javax.swing.JComboBox<>();
        tf_newunanswer = new javax.swing.JTextField();
        SaveNewU = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        estcolor = new javax.swing.JButton();
        AdministrarUsuarios = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainTree = new javax.swing.JTree();
        LockUser = new javax.swing.JDialog();
        lockscreenpw = new javax.swing.JPasswordField();
        namelockscreen = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        Archives = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TreeArchives = new javax.swing.JTree();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableArchives = new javax.swing.JTable();
        Console = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        ConsoleText = new javax.swing.JTextArea();
        TextEditor = new javax.swing.JDialog();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextPane();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        SaveDoc = new javax.swing.JMenuItem();
        Netbeans = new javax.swing.JDialog();
        Agenda = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cal = new com.toedter.calendar.JCalendar();
        jScrollPane2 = new javax.swing.JScrollPane();
        agenda = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        Type = new javax.swing.JComboBox<>();
        Title = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        Fecha = new com.toedter.calendar.JDateChooser();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Content = new javax.swing.JTextArea();
        start = new javax.swing.JSpinner();
        end = new javax.swing.JSpinner();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        Notes = new javax.swing.JButton();
        savedate = new javax.swing.JButton();
        Images = new javax.swing.JDialog();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        MainImage = new javax.swing.JLabel();
        Icon2 = new javax.swing.JLabel();
        Icon3 = new javax.swing.JLabel();
        Icon1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        AddImages = new javax.swing.JMenuItem();
        MusicPlayer = new javax.swing.JDialog();
        MusicPB = new javax.swing.JProgressBar();
        SongName = new javax.swing.JLabel();
        TotalTime = new javax.swing.JLabel();
        SongName1 = new javax.swing.JLabel();
        PreviousSong = new javax.swing.JButton();
        PlayPause = new javax.swing.JButton();
        NextSong = new javax.swing.JButton();
        ImportMusic = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        Playlist = new javax.swing.JList<>();
        StopButton = new javax.swing.JButton();
        Messenger = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Contacts = new javax.swing.JList<>();
        SendM = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Message = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        Convo = new javax.swing.JTextArea();
        Icons = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        bg1 = new javax.swing.JLabel();
        ChangeBG = new javax.swing.JDialog();
        NewBDay = new javax.swing.JDialog();
        CalendarBday = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        SaveBDay = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RecycleBin = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        RecycleBinTable = new javax.swing.JTable();
        ArchivesPM = new javax.swing.JPopupMenu();
        Copy = new javax.swing.JMenuItem();
        Cut = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        Rename = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        RBPM = new javax.swing.JPopupMenu();
        Restore = new javax.swing.JMenuItem();
        DeleteP = new javax.swing.JMenuItem();
        TextPM = new javax.swing.JPopupMenu();
        EditText = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        FontChooser = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        fonts = new javax.swing.JList<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        style = new javax.swing.JList<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        size = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        Okay = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        muestra = new javax.swing.JLabel();
        Home = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        HomeB = new javax.swing.JButton();
        UsersB = new javax.swing.JButton();
        NotifsB = new javax.swing.JButton();
        PerfilB = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        jLabel67 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jScrollPane27 = new javax.swing.JScrollPane();
        Wall = new javax.swing.JTable();
        Status = new javax.swing.JDialog();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        NewStatus = new javax.swing.JTextArea();
        Share = new javax.swing.JButton();
        Picture = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        PreviewPic = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        DescPic = new javax.swing.JTextArea();
        SharePic = new javax.swing.JButton();
        selectpic = new javax.swing.JButton();
        Album = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        AlbumList = new javax.swing.JList<>();
        AddPics = new javax.swing.JButton();
        AlbumTitle = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        DescAlbum = new javax.swing.JTextArea();
        ShareAlbum = new javax.swing.JButton();
        PerfilPreview = new javax.swing.JDialog();
        jPanel15 = new javax.swing.JPanel();
        UserPic = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        ContAmigos = new javax.swing.JLabel();
        ContP = new javax.swing.JLabel();
        AddB = new javax.swing.JButton();
        MyProfile = new javax.swing.JDialog();
        jPanel18 = new javax.swing.JPanel();
        UserPic1 = new javax.swing.JLabel();
        UserName1 = new javax.swing.JLabel();
        ContAmigos1 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        ContP1 = new javax.swing.JLabel();
        ChangePP = new javax.swing.JButton();
        jScrollPane28 = new javax.swing.JScrollPane();
        mywall = new javax.swing.JTable();
        Notifications = new javax.swing.JDialog();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        notifs = new javax.swing.JTable();
        AllUsersPV = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        FilterUsuarios = new javax.swing.JComboBox<>();
        jScrollPane20 = new javax.swing.JScrollPane();
        UsuariosLista = new javax.swing.JList<>();
        ViewStatus = new javax.swing.JDialog();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        NewStatus1 = new javax.swing.JTextArea();
        namepost = new javax.swing.JLabel();
        LikePost = new javax.swing.JButton();
        CommentPost = new javax.swing.JButton();
        ViewPicture = new javax.swing.JDialog();
        jPanel24 = new javax.swing.JPanel();
        PreviewPic1 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        DescPic1 = new javax.swing.JTextArea();
        commentp = new javax.swing.JButton();
        likep = new javax.swing.JButton();
        ViewAlbum = new javax.swing.JDialog();
        jPanel25 = new javax.swing.JPanel();
        AddPics1 = new javax.swing.JButton();
        albmt = new javax.swing.JTextField();
        jScrollPane26 = new javax.swing.JScrollPane();
        albmdesc = new javax.swing.JTextArea();
        ShareAlbum1 = new javax.swing.JButton();
        pic1 = new javax.swing.JLabel();
        pic2 = new javax.swing.JLabel();
        pic3 = new javax.swing.JLabel();
        pic4 = new javax.swing.JLabel();
        PMPosts = new javax.swing.JPopupMenu();
        View = new javax.swing.JMenuItem();
        IndPic = new javax.swing.JDialog();
        jPanel17 = new javax.swing.JPanel();
        mainpicv = new javax.swing.JLabel();
        MainMenu = new javax.swing.JToolBar();
        archives = new javax.swing.JButton();
        console = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        texteditor = new javax.swing.JButton();
        calendar = new javax.swing.JButton();
        netbeans = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        images = new javax.swing.JButton();
        music = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        socials = new javax.swing.JButton();
        im = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        recycle = new javax.swing.JButton();
        Time = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        m_admin = new javax.swing.JMenu();
        m_newuser = new javax.swing.JMenuItem();
        m_allusers = new javax.swing.JMenuItem();
        m_ajustes = new javax.swing.JMenu();
        m_newname = new javax.swing.JMenuItem();
        m_bday = new javax.swing.JMenuItem();
        m_email = new javax.swing.JMenuItem();
        m_newun = new javax.swing.JMenuItem();
        m_newpw = new javax.swing.JMenuItem();
        m_lock = new javax.swing.JMenuItem();
        m_logout = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        m_changebg = new javax.swing.JMenuItem();
        m_changecolor = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        helpicons = new javax.swing.JMenuItem();
        blankspace = new javax.swing.JMenu();
        Date = new javax.swing.JMenu();

        LogIn.setMinimumSize(new java.awt.Dimension(490, 330));
        LogIn.setResizable(false);
        LogIn.setSize(new java.awt.Dimension(490, 330));
        LogIn.getContentPane().setLayout(null);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setText("Usuario");
        LogIn.getContentPane().add(jLabel45);
        jLabel45.setBounds(60, 100, 80, 20);

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setText("Contraseña");
        LogIn.getContentPane().add(jLabel46);
        jLabel46.setBounds(60, 150, 80, 20);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel47.setText("Iniciar Sesión");
        LogIn.getContentPane().add(jLabel47);
        jLabel47.setBounds(170, 30, 170, 40);
        LogIn.getContentPane().add(jt_userlogin);
        jt_userlogin.setBounds(160, 100, 270, 28);
        LogIn.getContentPane().add(pf_pwlogin);
        pf_pwlogin.setBounds(160, 150, 270, 28);

        b_login.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        b_login.setText("Ingresar");
        b_login.setBorderPainted(false);
        b_login.setOpaque(false);
        b_login.setPreferredSize(new java.awt.Dimension(80, 31));
        b_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_loginMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(b_login);
        b_login.setBounds(160, 240, 80, 31);

        b_cancel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        b_cancel.setText("Cancelar");
        b_cancel.setOpaque(false);
        b_cancel.setPreferredSize(new java.awt.Dimension(80, 31));
        b_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_cancelMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(b_cancel);
        b_cancel.setBounds(255, 240, 80, 31);

        b_shutdown.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        b_shutdown.setText("Apagar");
        b_shutdown.setOpaque(false);
        b_shutdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_shutdownMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(b_shutdown);
        b_shutdown.setBounds(350, 240, 80, 31);

        jb_forgotpw.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        jb_forgotpw.setForeground(new java.awt.Color(51, 51, 51));
        jb_forgotpw.setText("¿Ha olvidado su contraseña?");
        jb_forgotpw.setBorderPainted(false);
        jb_forgotpw.setContentAreaFilled(false);
        jb_forgotpw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_forgotpwMouseClicked(evt);
            }
        });
        LogIn.getContentPane().add(jb_forgotpw);
        jb_forgotpw.setBounds(280, 180, 169, 23);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/60-beach-landscape-blurred-backgrounds-7-638.jpg"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(338, 159));
        bg.setMinimumSize(new java.awt.Dimension(338, 159));
        bg.setPreferredSize(new java.awt.Dimension(338, 159));
        LogIn.getContentPane().add(bg);
        bg.setBounds(0, 0, 490, 300);

        m_changebg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgc.png"))); // NOI18N
        m_changebg1.setText("Cambiar Fondo de Pantalla");
        m_changebg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_changebg1ActionPerformed(evt);
            }
        });
        PopUpMain.add(m_changebg1);

        m_changecolor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bg.png"))); // NOI18N
        m_changecolor1.setText("Cambiar Color del Sistema");
        m_changecolor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_changecolor1ActionPerformed(evt);
            }
        });
        PopUpMain.add(m_changecolor1);

        m_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/magnifyingglass.png"))); // NOI18N
        m_help.setText("Ayuda");
        m_help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_helpActionPerformed(evt);
            }
        });
        PopUpMain.add(m_help);

        NewUser.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        NewUser.setTitle("Nuevo Usuario");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setText("Creando una nueva cuenta");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel49.setText("Con una nueva cuenta, el usuario tendrá acceso a su propia selección de ajustes, archivos, música,");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel50.setText(" imágenes y, ¡mucho más! Esto solo tomará algunos instantes.");

        tf_newuname.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newuname.setText("Nombre");
        tf_newuname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearField(evt);
            }
        });

        tf_newunuser.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newunuser.setText("Nombre de Usuario");
        tf_newunuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newunuserMouseClicked(evt);
            }
        });

        tf_newuemail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newuemail.setText("Correo Electrónico");
        tf_newuemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newuemailMouseClicked(evt);
            }
        });

        tf_newunpw.setText("Contraseña");
        tf_newunpw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newunpwMouseClicked(evt);
            }
        });

        jd_newbday.setToolTipText("Cumpleaños");

        cb_question.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_question.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una pregunta...", "¿Cuál es tu color favorito?", "¿Cuál es tu superhéroe favorito?", "¿Cuál es el nombre de tu primera escuela?", "¿En qué mes nació tu mamá?", "¿Qué color fue tu primer carro?" }));

        tf_newunanswer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tf_newunanswer.setText("Respuesta");
        tf_newunanswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_newunanswerMouseClicked(evt);
            }
        });

        SaveNewU.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        SaveNewU.setText("Guardar");
        SaveNewU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveNewUMouseClicked(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel52.setText(" y un número obligatoriamente.");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel53.setText("La contraseña debe de contener una letra mayúscula");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel55.setText("Selecciona una pregunta de seguridad");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel56.setText("caso de que olvides tu contraseña.");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel57.setText("que ayudará a recuperar tus datos en ");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel58.setText("Fecha de Cumpleaños y Edad");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel59.setText("Contraseña");

        color.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        color.setOpaque(true);

        estcolor.setText("Seleccionar Color del Sistema");
        estcolor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estcolorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(estcolor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveNewU, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_newuname, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(tf_newuemail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_newunanswer)
                                    .addComponent(cb_question, 0, 310, Short.MAX_VALUE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel58)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(tf_newunuser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(80, 80, 80)
                                    .addComponent(jd_newbday, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(s_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel59)
                                    .addComponent(tf_newunpw, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addGap(6, 6, 6)
                .addComponent(jLabel50)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_newuname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_newuemail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_newunuser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jd_newbday, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel58)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_newunpw, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel52))
                            .addComponent(jLabel53))))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cb_question, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel55)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel56)))
                        .addGap(18, 18, 18)
                        .addComponent(tf_newunanswer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveNewU, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estcolor)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(32, 32, 32))
        );

        NewUser.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        AdministrarUsuarios.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        AdministrarUsuarios.setTitle("Administrar Usuarios");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Z:\\");
            MainTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            jScrollPane1.setViewportView(MainTree);

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout AdministrarUsuariosLayout = new javax.swing.GroupLayout(AdministrarUsuarios.getContentPane());
            AdministrarUsuarios.getContentPane().setLayout(AdministrarUsuariosLayout);
            AdministrarUsuariosLayout.setHorizontalGroup(
                AdministrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministrarUsuariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            AdministrarUsuariosLayout.setVerticalGroup(
                AdministrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministrarUsuariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            LockUser.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            LockUser.setTitle("Pantalla Bloqueada");
            LockUser.setMinimumSize(new java.awt.Dimension(1043, 680));
            LockUser.setResizable(false);
            LockUser.setSize(new java.awt.Dimension(1043, 680));
            LockUser.getContentPane().setLayout(null);

            lockscreenpw.setForeground(new java.awt.Color(153, 153, 153));
            lockscreenpw.setOpaque(false);
            lockscreenpw.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lockscreenpwMouseClicked(evt);
                }
            });
            LockUser.getContentPane().add(lockscreenpw);
            lockscreenpw.setBounds(380, 360, 270, 30);

            namelockscreen.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
            namelockscreen.setForeground(new java.awt.Color(153, 153, 153));
            namelockscreen.setText("Nombre de Usuario");
            LockUser.getContentPane().add(namelockscreen);
            namelockscreen.setBounds(400, 320, 240, 30);

            warning.setForeground(new java.awt.Color(153, 153, 153));
            warning.setText("Ingrese contraseña para desbloquear.");
            LockUser.getContentPane().add(warning);
            warning.setBounds(430, 360, 190, 30);

            jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/default-avatar.png"))); // NOI18N
            jLabel54.setText("jLabel54");
            LockUser.getContentPane().add(jLabel54);
            jLabel54.setBounds(460, 200, 100, 100);

            jButton1.setText("Desbloquear");
            jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton1MouseClicked(evt);
                }
            });
            LockUser.getContentPane().add(jButton1);
            jButton1.setBounds(460, 410, 100, 23);

            jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Black-Wallpaper-HD.jpg"))); // NOI18N
            LockUser.getContentPane().add(jLabel60);
            jLabel60.setBounds(0, 0, 1350, 910);

            Archives.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Archives.setTitle("Navegador de Archivos");
            Archives.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    ArchivesClosed(evt);
                }
            });

            treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Sistema");
            TreeArchives.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            TreeArchives.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TreeArchivesMouseClicked(evt);
                }
            });
            jScrollPane3.setViewportView(TreeArchives);

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            );

            jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPane5MouseClicked(evt);
                }
            });

            TableArchives.setAutoCreateRowSorter(true);
            TableArchives.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            TableArchives.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Nombre", "Fecha de modificación", "Tipo", "Tamaño"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            TableArchives.setGridColor(new java.awt.Color(255, 255, 255));
            TableArchives.setShowHorizontalLines(false);
            TableArchives.setShowVerticalLines(false);
            TableArchives.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TableArchivesMouseClicked(evt);
                }
            });
            jScrollPane5.setViewportView(TableArchives);

            javax.swing.GroupLayout ArchivesLayout = new javax.swing.GroupLayout(Archives.getContentPane());
            Archives.getContentPane().setLayout(ArchivesLayout);
            ArchivesLayout.setHorizontalGroup(
                ArchivesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ArchivesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addContainerGap())
            );
            ArchivesLayout.setVerticalGroup(
                ArchivesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArchivesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(ArchivesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(17, 17, 17))
            );

            Console.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Console.setTitle("Consola");
            Console.setMinimumSize(new java.awt.Dimension(630, 370));

            ConsoleText.setBackground(new java.awt.Color(0, 0, 0));
            ConsoleText.setColumns(20);
            ConsoleText.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
            ConsoleText.setForeground(new java.awt.Color(204, 204, 204));
            ConsoleText.setRows(5);
            ConsoleText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            ConsoleText.setMaximumSize(null);
            ConsoleText.setMinimumSize(new java.awt.Dimension(630, 370));
            ConsoleText.setPreferredSize(new java.awt.Dimension(630, 370));
            ConsoleText.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    ConsoleTextKeyPressed(evt);
                }
            });
            jScrollPane6.setViewportView(ConsoleText);

            Console.getContentPane().add(jScrollPane6, java.awt.BorderLayout.CENTER);

            TextEditor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            TextEditor.setTitle("Editor de Texto");

            txt.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    txtMouseClicked(evt);
                }
            });
            jScrollPane8.setViewportView(txt);

            jMenu4.setText("File");

            Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
            Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/newuser.png"))); // NOI18N
            Open.setText("Abrir Documento...");
            Open.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    OpenActionPerformed(evt);
                }
            });
            jMenu4.add(Open);

            SaveDoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
            SaveDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
            SaveDoc.setText("Guardar");
            SaveDoc.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SaveDocActionPerformed(evt);
                }
            });
            jMenu4.add(SaveDoc);

            jMenuBar3.add(jMenu4);

            TextEditor.setJMenuBar(jMenuBar3);

            javax.swing.GroupLayout TextEditorLayout = new javax.swing.GroupLayout(TextEditor.getContentPane());
            TextEditor.getContentPane().setLayout(TextEditorLayout);
            TextEditorLayout.setHorizontalGroup(
                TextEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
            );
            TextEditorLayout.setVerticalGroup(
                TextEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            );

            Netbeans.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Netbeans.setTitle("NetBeans");

            Agenda.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Agenda.setTitle("Calendario & Agenda");
            Agenda.setBackground(new java.awt.Color(255, 255, 255));

            jTabbedPane1.setMinimumSize(new java.awt.Dimension(300, 426));
            jTabbedPane1.setName(""); // NOI18N

            jPanel10.setBackground(new java.awt.Color(255, 255, 255));

            jPanel6.setBackground(new java.awt.Color(255, 255, 255));

            cal.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    calMouseClicked(evt);
                }
            });
            cal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent evt) {
                    calPropertyChange(evt);
                }
            });

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cal, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addContainerGap())
            );

            agenda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            agenda.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Tipo", "Título", "¿Recordatorio?"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            agenda.setAutoscrolls(false);
            agenda.setRowHeight(40);
            agenda.setSelectionBackground(new java.awt.Color(223, 248, 248));
            agenda.setSelectionForeground(new java.awt.Color(0, 0, 0));
            agenda.getTableHeader().setResizingAllowed(false);
            jScrollPane2.setViewportView(agenda);

            javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
            jPanel10.setLayout(jPanel10Layout);
            jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            jTabbedPane1.addTab("Visualizar Agenda", jPanel10);

            jPanel12.setBackground(new java.awt.Color(255, 255, 255));

            jLabel51.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
            jLabel51.setText("Nueva Actividad");

            jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel61.setText("Tipo de Actividad");

            Type.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un Tipo --", "Evento", "Tarea" }));
            Type.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    TypeItemStateChanged(evt);
                }
            });

            Title.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

            jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel62.setText("Título");

            Fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent evt) {
                    FechaPropertyChange(evt);
                }
            });

            jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel63.setText("Fecha");

            Content.setColumns(20);
            Content.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            Content.setRows(5);
            Content.setEnabled(false);
            jScrollPane15.setViewportView(Content);

            start.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.MINUTE));
            start.setEnabled(false);

            end.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1537083105508L), null, java.util.Calendar.MINUTE));
            end.setEnabled(false);

            jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel64.setText("Hora de Inicio");
            jLabel64.setEnabled(false);

            jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel65.setText("Hora de Finalización");
            jLabel65.setEnabled(false);

            jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
            jLabel66.setText("Contenido");
            jLabel66.setEnabled(false);

            Notes.setText("Seleccionar Notas");
            Notes.setEnabled(false);
            Notes.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    NotesMouseClicked(evt);
                }
            });

            savedate.setText("Guardar");
            savedate.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    savedateMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
            jPanel12.setLayout(jPanel12Layout);
            jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel61)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel62)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addComponent(savedate))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel63)
                                .addComponent(jLabel64)
                                .addComponent(jLabel65)
                                .addComponent(jLabel66))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Notes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(end, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(start)
                                .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap())
            );
            jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel51)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel62))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addGap(11, 11, 11)
                            .addComponent(Notes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(savedate)
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
            jPanel11.setLayout(jPanel11Layout);
            jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            jTabbedPane1.addTab("Crear Apunte", jPanel11);

            javax.swing.GroupLayout AgendaLayout = new javax.swing.GroupLayout(Agenda.getContentPane());
            Agenda.getContentPane().setLayout(AgendaLayout);
            AgendaLayout.setHorizontalGroup(
                AgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            AgendaLayout.setVerticalGroup(
                AgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            Images.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Images.setTitle("Visor de Imágenes");
            Images.setBackground(new java.awt.Color(255, 255, 255));
            Images.setResizable(false);

            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/right arrow.png"))); // NOI18N
            jButton2.setBorder(null);
            jButton2.setContentAreaFilled(false);
            jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton2MouseClicked(evt);
                }
            });

            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/left arrow.png"))); // NOI18N
            jButton3.setContentAreaFilled(false);
            jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton3MouseClicked(evt);
                }
            });

            MainImage.setBackground(new java.awt.Color(243, 243, 243));
            MainImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            MainImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            MainImage.setOpaque(true);

            Icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            Icon2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            Icon2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Icon2MouseClicked(evt);
                }
            });

            Icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            Icon3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            Icon3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Icon3MouseClicked(evt);
                }
            });

            Icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            Icon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            Icon1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    Icon1MouseClicked(evt);
                }
            });

            jMenu1.setText("Opciones");

            AddImages.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
            AddImages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgc.png"))); // NOI18N
            AddImages.setText("Importar Imágenes");
            AddImages.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddImagesActionPerformed(evt);
                }
            });
            jMenu1.add(AddImages);

            jMenuBar1.add(jMenu1);

            Images.setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout ImagesLayout = new javax.swing.GroupLayout(Images.getContentPane());
            Images.getContentPane().setLayout(ImagesLayout);
            ImagesLayout.setHorizontalGroup(
                ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImagesLayout.createSequentialGroup()
                    .addGroup(ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(290, 290, 290)
                            .addComponent(Icon2))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(MainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(513, 513, 513)
                            .addComponent(Icon3))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(Icon1))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(715, 715, 715)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            ImagesLayout.setVerticalGroup(
                ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ImagesLayout.createSequentialGroup()
                    .addGroup(ImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(397, 397, 397)
                            .addComponent(Icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(438, 438, 438)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(MainImage, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(397, 397, 397)
                            .addComponent(Icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(397, 397, 397)
                            .addComponent(Icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImagesLayout.createSequentialGroup()
                            .addGap(433, 433, 433)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(21, 21, 21))
            );

            MusicPlayer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            MusicPlayer.setTitle("Reproductor de Música");
            MusicPlayer.setMinimumSize(new java.awt.Dimension(360, 330));
            MusicPlayer.setResizable(false);
            MusicPlayer.setSize(new java.awt.Dimension(360, 315));
            MusicPlayer.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    MusicPlayerWindowClosing(evt);
                }
            });

            SongName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

            TotalTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            TotalTime.setText("00:00");

            SongName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            SongName1.setText("Now Playing:");

            PreviousSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back-button.png"))); // NOI18N
            PreviousSong.setBorderPainted(false);
            PreviousSong.setContentAreaFilled(false);
            PreviousSong.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PreviousSongMouseClicked(evt);
                }
            });
            PreviousSong.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PreviousSongActionPerformed(evt);
                }
            });

            PlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play-button.png"))); // NOI18N
            PlayPause.setBorderPainted(false);
            PlayPause.setContentAreaFilled(false);
            PlayPause.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PlayPauseMouseClicked(evt);
                }
            });

            NextSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next-button.png"))); // NOI18N
            NextSong.setBorderPainted(false);
            NextSong.setContentAreaFilled(false);
            NextSong.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    NextSongMouseClicked(evt);
                }
            });

            ImportMusic.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
            ImportMusic.setText("Add New Song");
            ImportMusic.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ImportMusicMouseClicked(evt);
                }
            });

            Playlist.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
            Playlist.setModel(new DefaultListModel());
            Playlist.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PlaylistMouseClicked(evt);
                }
            });
            jScrollPane4.setViewportView(Playlist);

            StopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/square-inside-a-circle.png"))); // NOI18N
            StopButton.setBorderPainted(false);
            StopButton.setContentAreaFilled(false);
            StopButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    StopButtonMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout MusicPlayerLayout = new javax.swing.GroupLayout(MusicPlayer.getContentPane());
            MusicPlayer.getContentPane().setLayout(MusicPlayerLayout);
            MusicPlayerLayout.setHorizontalGroup(
                MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MusicPlayerLayout.createSequentialGroup()
                    .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(MusicPB, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(430, 430, 430)
                            .addComponent(TotalTime))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(PreviousSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(PlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(NextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82)
                            .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(ImportMusic))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(MusicPlayerLayout.createSequentialGroup()
                                    .addComponent(SongName1)
                                    .addGap(11, 11, 11)
                                    .addComponent(SongName, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            MusicPlayerLayout.setVerticalGroup(
                MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MusicPlayerLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(MusicPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(TotalTime)
                    .addGap(14, 14, 14)
                    .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(MusicPlayerLayout.createSequentialGroup()
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SongName1)
                                .addComponent(SongName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MusicPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PreviousSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MusicPlayerLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(ImportMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            Messenger.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Messenger.setTitle("Mensajería");
            Messenger.setBackground(new java.awt.Color(255, 255, 255));

            jPanel2.setBackground(new java.awt.Color(176, 244, 244));
            jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            Contacts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contactos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N
            Contacts.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            Contacts.setModel(new DefaultListModel());
            Contacts.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ContactsMouseClicked(evt);
                }
            });
            jScrollPane12.setViewportView(Contacts);

            SendM.setText("Send");
            SendM.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    SendMMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(SendM, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                    .addComponent(SendM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37))
            );

            jPanel8.setBackground(new java.awt.Color(220, 245, 253));
            jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            Message.setColumns(20);
            Message.setRows(5);
            jScrollPane9.setViewportView(Message);

            Convo.setEditable(false);
            Convo.setColumns(20);
            Convo.setRows(5);
            Convo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conversación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N
            jScrollPane10.setViewportView(Convo);

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                        .addContainerGap()))
            );
            jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(109, Short.MAX_VALUE)))
            );

            javax.swing.GroupLayout MessengerLayout = new javax.swing.GroupLayout(Messenger.getContentPane());
            Messenger.getContentPane().setLayout(MessengerLayout);
            MessengerLayout.setHorizontalGroup(
                MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessengerLayout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            MessengerLayout.setVerticalGroup(
                MessengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            Icons.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Icons.setTitle("Ayuda");
            Icons.setBackground(new java.awt.Color(255, 255, 255));
            Icons.setMinimumSize(new java.awt.Dimension(750, 580));
            Icons.setResizable(false);
            Icons.setSize(new java.awt.Dimension(750, 580));
            Icons.getContentPane().setLayout(null);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Messenger.png"))); // NOI18N
            jLabel1.setText("jLabel1");
            Icons.getContentPane().add(jLabel1);
            jLabel1.setBounds(390, 280, 55, 47);

            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consola.png"))); // NOI18N
            jLabel5.setText("jLabel1");
            Icons.getContentPane().add(jLabel5);
            jLabel5.setBounds(40, 190, 55, 47);

            jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Archivos.png"))); // NOI18N
            jLabel6.setText("jLabel1");
            Icons.getContentPane().add(jLabel6);
            jLabel6.setBounds(40, 100, 55, 47);

            jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calendario.png"))); // NOI18N
            jLabel7.setText("jLabel1");
            Icons.getContentPane().add(jLabel7);
            jLabel7.setBounds(40, 470, 55, 47);

            jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NetBeans.png"))); // NOI18N
            jLabel8.setText("jLabel1");
            Icons.getContentPane().add(jLabel8);
            jLabel8.setBounds(40, 370, 55, 60);

            jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Texto.png"))); // NOI18N
            Icons.getContentPane().add(jLabel9);
            jLabel9.setBounds(40, 280, 55, 47);

            jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen.png"))); // NOI18N
            jLabel10.setText("jLabel1");
            Icons.getContentPane().add(jLabel10);
            jLabel10.setBounds(390, 190, 55, 47);

            jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Musica.png"))); // NOI18N
            jLabel11.setText("jLabel1");
            Icons.getContentPane().add(jLabel11);
            jLabel11.setBounds(390, 90, 55, 59);

            jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reciclaje.png"))); // NOI18N
            jLabel12.setText("jLabel1");
            Icons.getContentPane().add(jLabel12);
            jLabel12.setBounds(390, 460, 55, 63);

            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SM.png"))); // NOI18N
            jLabel13.setText("jLabel1");
            Icons.getContentPane().add(jLabel13);
            jLabel13.setBounds(390, 370, 55, 58);

            jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel14.setText("Organizador de Archivos");
            Icons.getContentPane().add(jLabel14);
            jLabel14.setBounds(110, 90, 160, 20);

            jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel15.setText("Consola");
            Icons.getContentPane().add(jLabel15);
            jLabel15.setBounds(110, 170, 51, 20);

            jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel16.setText("Editor de Texto");
            Icons.getContentPane().add(jLabel16);
            jLabel16.setBounds(110, 260, 97, 20);

            jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel17.setText("Netbeans");
            Icons.getContentPane().add(jLabel17);
            jLabel17.setBounds(110, 350, 60, 20);

            jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel18.setText("Agenda & Calendario");
            Icons.getContentPane().add(jLabel18);
            jLabel18.setBounds(110, 450, 138, 20);

            jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel19.setText("Visor de Imágenes");
            Icons.getContentPane().add(jLabel19);
            jLabel19.setBounds(470, 180, 117, 20);

            jLabel20.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel20.setText("Reproductor de Música");
            Icons.getContentPane().add(jLabel20);
            jLabel20.setBounds(470, 90, 146, 20);

            jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel21.setText("Messenger");
            Icons.getContentPane().add(jLabel21);
            jLabel21.setBounds(470, 260, 67, 20);

            jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel22.setText("Sociales");
            Icons.getContentPane().add(jLabel22);
            jLabel22.setBounds(470, 360, 51, 20);

            jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel23.setText("Papelera de Reciclaje");
            Icons.getContentPane().add(jLabel23);
            jLabel23.setBounds(470, 450, 135, 20);

            jLabel24.setText("carpetas para un fácil acceso.");
            Icons.getContentPane().add(jLabel24);
            jLabel24.setBounds(110, 130, 230, 20);

            jLabel25.setText("Todos los archivos del Sistemas ordenados por");
            Icons.getContentPane().add(jLabel25);
            jLabel25.setBounds(110, 110, 230, 20);

            jLabel26.setText("Consola de comandos que muestra la carpeta ");
            Icons.getContentPane().add(jLabel26);
            jLabel26.setBounds(110, 190, 230, 20);

            jLabel27.setText("actual y presenta otra serie de funciones.");
            Icons.getContentPane().add(jLabel27);
            jLabel27.setBounds(110, 210, 230, 20);

            jLabel28.setText("Editor de texto que permite crear y modificar ");
            Icons.getContentPane().add(jLabel28);
            jLabel28.setBounds(110, 280, 230, 20);

            jLabel29.setText("archivos .txt.");
            Icons.getContentPane().add(jLabel29);
            jLabel29.setBounds(110, 300, 230, 20);

            jLabel30.setText("Módulo que permite la creación de archivos tipo");
            Icons.getContentPane().add(jLabel30);
            jLabel30.setBounds(110, 370, 230, 20);

            jLabel31.setText(".java y que implementa la metodología POO.");
            Icons.getContentPane().add(jLabel31);
            jLabel31.setBounds(110, 390, 230, 20);

            jLabel32.setText("permite la creación de eventos y tares.");
            Icons.getContentPane().add(jLabel32);
            jLabel32.setBounds(110, 500, 230, 20);

            jLabel33.setText("Organizador diario, semanal y mensual que ");
            Icons.getContentPane().add(jLabel33);
            jLabel33.setBounds(110, 480, 230, 20);

            jLabel34.setText("el navegador de archivos.");
            Icons.getContentPane().add(jLabel34);
            jLabel34.setBounds(470, 130, 230, 20);

            jLabel35.setText("Reproductor de archivos .mp3 tomados desde ");
            Icons.getContentPane().add(jLabel35);
            jLabel35.setBounds(470, 110, 230, 20);

            jLabel36.setText("Visor de imágenes que accede a una colección ");
            Icons.getContentPane().add(jLabel36);
            jLabel36.setBounds(470, 200, 230, 20);

            jLabel37.setText("de imágenes dentro de una carpeta.");
            Icons.getContentPane().add(jLabel37);
            jLabel37.setBounds(470, 220, 230, 20);

            jLabel38.setText("Un sistema de mensajería dentro del Sistema ");
            Icons.getContentPane().add(jLabel38);
            jLabel38.setBounds(470, 280, 230, 20);

            jLabel39.setText("que permite la comunicación entre usuarios.");
            Icons.getContentPane().add(jLabel39);
            jLabel39.setBounds(470, 300, 230, 20);

            jLabel40.setText("Módulo que permite compartir con grupos de ");
            Icons.getContentPane().add(jLabel40);
            jLabel40.setBounds(470, 380, 230, 20);

            jLabel41.setText("amigos entre los usuarios. ");
            Icons.getContentPane().add(jLabel41);
            jLabel41.setBounds(470, 400, 230, 20);

            jLabel42.setText("Los archivos eliminados desde el navegador ");
            Icons.getContentPane().add(jLabel42);
            jLabel42.setBounds(470, 470, 230, 20);

            jLabel43.setText("de archivos pueden ser encontrados aquí.");
            Icons.getContentPane().add(jLabel43);
            jLabel43.setBounds(470, 490, 230, 20);

            jLabel44.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
            jLabel44.setText("Menú de Íconos");
            Icons.getContentPane().add(jLabel44);
            jLabel44.setBounds(40, 0, 320, 80);
            Icons.getContentPane().add(jSeparator5);
            jSeparator5.setBounds(30, 62, 680, 10);

            bg1.setBackground(new java.awt.Color(255, 255, 255));
            bg1.setOpaque(true);
            Icons.getContentPane().add(bg1);
            bg1.setBounds(0, 70, 760, 460);

            ChangeBG.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            ChangeBG.setTitle("Cambiar Fondo de Pantalla");

            NewBDay.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            NewBDay.setTitle("Modificar Cumpleaños");
            NewBDay.setBackground(new java.awt.Color(253, 240, 240));
            NewBDay.setForeground(new java.awt.Color(255, 153, 0));
            NewBDay.setMinimumSize(new java.awt.Dimension(450, 250));
            NewBDay.setResizable(false);
            NewBDay.setSize(new java.awt.Dimension(450, 250));
            NewBDay.getContentPane().setLayout(null);

            CalendarBday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            CalendarBday.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            NewBDay.getContentPane().add(CalendarBday);
            CalendarBday.setBounds(200, 10, 222, 189);

            jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel2.setText("Seleccione una nueva fecha");
            NewBDay.getContentPane().add(jLabel2);
            jLabel2.setBounds(20, 70, 170, 16);

            SaveBDay.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            SaveBDay.setText("Guardar");
            SaveBDay.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    SaveBDayMouseClicked(evt);
                }
            });
            NewBDay.getContentPane().add(SaveBDay);
            SaveBDay.setBounds(60, 130, 80, 25);

            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel3.setText("de Nacimiento");
            NewBDay.getContentPane().add(jLabel3);
            jLabel3.setBounds(60, 90, 100, 16);

            jLabel4.setBackground(new java.awt.Color(255, 255, 255));
            jLabel4.setForeground(new java.awt.Color(255, 236, 204));
            jLabel4.setOpaque(true);
            NewBDay.getContentPane().add(jLabel4);
            jLabel4.setBounds(0, 0, 440, 210);

            RecycleBin.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            RecycleBin.setTitle("Papelera de Reciclaje");

            jScrollPane7.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPane7MouseClicked(evt);
                }
            });

            RecycleBinTable.setAutoCreateRowSorter(true);
            RecycleBinTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            RecycleBinTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Nombre", "Fecha de modificación", "Tipo", "Tamaño"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            RecycleBinTable.setGridColor(new java.awt.Color(255, 255, 255));
            RecycleBinTable.setShowHorizontalLines(false);
            RecycleBinTable.setShowVerticalLines(false);
            RecycleBinTable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    RecycleBinTableMouseClicked(evt);
                }
            });
            jScrollPane7.setViewportView(RecycleBinTable);

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 547, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                        .addContainerGap()))
            );
            jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 323, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap()))
            );

            RecycleBin.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

            Copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/copy.png"))); // NOI18N
            Copy.setText("Copy");
            Copy.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CopyActionPerformed(evt);
                }
            });
            ArchivesPM.add(Copy);

            Cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cut.png"))); // NOI18N
            Cut.setText("Cut");
            Cut.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CutActionPerformed(evt);
                }
            });
            ArchivesPM.add(Cut);

            Paste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/paste bp.png"))); // NOI18N
            Paste.setText("Paste");
            Paste.setEnabled(false);
            Paste.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PasteActionPerformed(evt);
                }
            });
            ArchivesPM.add(Paste);

            Rename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit p.png"))); // NOI18N
            Rename.setText("Rename...");
            Rename.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    RenameActionPerformed(evt);
                }
            });
            ArchivesPM.add(Rename);

            Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete tc.png"))); // NOI18N
            Delete.setText("Delete");
            Delete.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    DeleteMouseClicked(evt);
                }
            });
            Delete.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DeleteActionPerformed(evt);
                }
            });
            ArchivesPM.add(Delete);

            Restore.setText("Restore");
            Restore.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    RestoreActionPerformed(evt);
                }
            });
            RBPM.add(Restore);

            DeleteP.setText("Delete");
            DeleteP.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DeletePActionPerformed(evt);
                }
            });
            RBPM.add(DeleteP);

            EditText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/settings.png"))); // NOI18N
            EditText.setText("Properties");
            EditText.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    EditTextActionPerformed(evt);
                }
            });
            TextPM.add(EditText);

            Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
            Save.setText("Save");
            TextPM.add(Save);

            FontChooser.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            FontChooser.setTitle("Edit Text");

            jPanel9.setBackground(new java.awt.Color(218, 212, 206));

            fonts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11))); // NOI18N
            fonts.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            fonts.setModel(new DefaultListModel());
            jScrollPane11.setViewportView(fonts);

            style.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Style", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11))); // NOI18N
            style.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            style.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = { "Plain", "Bold", "Italic", "Bold Italic", "Underline" };
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            style.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            jScrollPane13.setViewportView(style);

            size.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Size", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 11))); // NOI18N
            size.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            size.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = { "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72" };
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            size.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            jScrollPane14.setViewportView(size);

            jButton4.setText("Cancel");
            jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton4MouseClicked(evt);
                }
            });

            Okay.setText("OK");
            Okay.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    OkayMouseClicked(evt);
                }
            });

            jButton5.setText("Elegir Color");
            jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton5MouseClicked(evt);
                }
            });

            muestra.setBackground(new java.awt.Color(0, 0, 0));
            muestra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            muestra.setOpaque(true);

            javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
            jPanel9.setLayout(jPanel9Layout);
            jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(muestra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5)
                            .addGap(60, 60, 60)
                            .addComponent(Okay)
                            .addGap(6, 6, 6)
                            .addComponent(jButton4))))
            );
            jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(muestra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Okay)
                                    .addComponent(jButton4))
                                .addComponent(jButton5))))
                    .addContainerGap())
            );

            javax.swing.GroupLayout FontChooserLayout = new javax.swing.GroupLayout(FontChooser.getContentPane());
            FontChooser.getContentPane().setLayout(FontChooserLayout);
            FontChooserLayout.setHorizontalGroup(
                FontChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            FontChooserLayout.setVerticalGroup(
                FontChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            Home.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Home.setTitle("The SN.");
            Home.setMaximumSize(new java.awt.Dimension(661, 503));
            Home.setMinimumSize(new java.awt.Dimension(661, 503));
            Home.setResizable(false);
            Home.setSize(new java.awt.Dimension(661, 503));

            jPanel13.setBackground(new java.awt.Color(255, 255, 255));
            jPanel13.setMaximumSize(new java.awt.Dimension(661, 503));
            jPanel13.setMinimumSize(new java.awt.Dimension(661, 503));

            jToolBar1.setBackground(new java.awt.Color(59, 89, 152));
            jToolBar1.setRollover(true);

            HomeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-home-filled-50.png"))); // NOI18N
            HomeB.setContentAreaFilled(false);
            HomeB.setFocusable(false);
            HomeB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            HomeB.setMaximumSize(new java.awt.Dimension(150, 57));
            HomeB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jToolBar1.add(HomeB);

            UsersB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-user-account-filled-50.png"))); // NOI18N
            UsersB.setContentAreaFilled(false);
            UsersB.setFocusable(false);
            UsersB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            UsersB.setMaximumSize(new java.awt.Dimension(150, 57));
            UsersB.setMinimumSize(new java.awt.Dimension(70, 57));
            UsersB.setPreferredSize(new java.awt.Dimension(70, 57));
            UsersB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            UsersB.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    UsersBMouseClicked(evt);
                }
            });
            jToolBar1.add(UsersB);

            NotifsB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-alarm-filled-50.png"))); // NOI18N
            NotifsB.setContentAreaFilled(false);
            NotifsB.setFocusable(false);
            NotifsB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            NotifsB.setMaximumSize(new java.awt.Dimension(150, 57));
            NotifsB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            NotifsB.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    NotifsBMouseClicked(evt);
                }
            });
            jToolBar1.add(NotifsB);

            PerfilB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-customer-filled-50.png"))); // NOI18N
            PerfilB.setContentAreaFilled(false);
            PerfilB.setFocusable(false);
            PerfilB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            PerfilB.setMaximumSize(new java.awt.Dimension(150, 57));
            PerfilB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            PerfilB.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PerfilBMouseClicked(evt);
                }
            });
            jToolBar1.add(PerfilB);

            jToolBar5.setRollover(true);

            jLabel67.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
            jLabel67.setText("Dinos que está pasando...");
            jToolBar5.add(jLabel67);

            jButton22.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-compose-80.png"))); // NOI18N
            jButton22.setText("Nuevo Estado");
            jButton22.setContentAreaFilled(false);
            jButton22.setFocusable(false);
            jButton22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButton22.setMaximumSize(new java.awt.Dimension(100, 51));
            jButton22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton22MouseClicked(evt);
                }
            });
            jToolBar5.add(jButton22);

            jButton23.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-picture-80.png"))); // NOI18N
            jButton23.setText("Nueva Foto");
            jButton23.setFocusable(false);
            jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButton23.setMaximumSize(new java.awt.Dimension(100, 51));
            jButton23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton23MouseClicked(evt);
                }
            });
            jToolBar5.add(jButton23);

            jButton24.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-photo-gallery-80.png"))); // NOI18N
            jButton24.setText("Nuevo Álbum de Fotos");
            jButton24.setFocusable(false);
            jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButton24.setMaximumSize(new java.awt.Dimension(150, 51));
            jButton24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton24MouseClicked(evt);
                }
            });
            jToolBar5.add(jButton24);

            jButton25.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-documentary-80.png"))); // NOI18N
            jButton25.setText("Nuevo Video");
            jButton25.setFocusable(false);
            jButton25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jButton25.setMaximumSize(new java.awt.Dimension(100, 51));
            jButton25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jButton25MouseClicked(evt);
                }
            });
            jToolBar5.add(jButton25);

            Wall.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            Wall.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Fecha de Creación", "Publicado Por", "Publicación", "Likes"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            Wall.setGridColor(new java.awt.Color(59, 89, 152));
            Wall.setRowHeight(40);
            Wall.setRowSelectionAllowed(false);
            Wall.setShowHorizontalLines(false);
            Wall.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    WallMouseClicked(evt);
                }
            });
            jScrollPane27.setViewportView(Wall);

            javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
            jPanel13.setLayout(jPanel13Layout);
            jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane27)
                    .addContainerGap())
            );
            jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            Home.getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

            Status.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Status.setTitle("Nuevo Estado");

            jPanel20.setBackground(new java.awt.Color(59, 89, 152));
            jPanel20.setForeground(new java.awt.Color(59, 89, 152));

            NewStatus.setColumns(20);
            NewStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            NewStatus.setRows(5);
            NewStatus.setText("¿Qué estás pensando?\n");
            NewStatus.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    NewStatusMouseClicked(evt);
                }
            });
            jScrollPane16.setViewportView(NewStatus);

            Share.setText("Compartir");
            Share.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ShareMouseClicked(evt);
                }
            });
            Share.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ShareActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
            jPanel20.setLayout(jPanel20Layout);
            jPanel20Layout.setHorizontalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(Share, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            jPanel20Layout.setVerticalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Share, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout StatusLayout = new javax.swing.GroupLayout(Status.getContentPane());
            Status.getContentPane().setLayout(StatusLayout);
            StatusLayout.setHorizontalGroup(
                StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            StatusLayout.setVerticalGroup(
                StatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            Picture.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Picture.setTitle("Nueva Imagen");

            jPanel21.setBackground(new java.awt.Color(59, 89, 152));

            PreviewPic.setBackground(new java.awt.Color(255, 255, 255));
            PreviewPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            PreviewPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            PreviewPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            PreviewPic.setOpaque(true);

            DescPic.setColumns(20);
            DescPic.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            DescPic.setRows(5);
            DescPic.setText("Cuéntanos más de esta imagen.\n¡Escribe una descripción!");
            DescPic.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    DescPicMouseClicked(evt);
                }
            });
            jScrollPane17.setViewportView(DescPic);

            SharePic.setText("Compartir");
            SharePic.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    SharePicMouseClicked(evt);
                }
            });

            selectpic.setText("Seleccionar Imagen");
            selectpic.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    selectpicMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
            jPanel21.setLayout(jPanel21Layout);
            jPanel21Layout.setHorizontalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(PreviewPic, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(selectpic)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SharePic)
                    .addGap(25, 25, 25))
            );
            jPanel21Layout.setVerticalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                    .addGap(0, 26, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                            .addComponent(PreviewPic, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectpic)
                        .addComponent(SharePic))
                    .addGap(24, 24, 24))
            );

            javax.swing.GroupLayout PictureLayout = new javax.swing.GroupLayout(Picture.getContentPane());
            Picture.getContentPane().setLayout(PictureLayout);
            PictureLayout.setHorizontalGroup(
                PictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            PictureLayout.setVerticalGroup(
                PictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            Album.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Album.setTitle("Nuevo Álbum");

            jPanel22.setBackground(new java.awt.Color(59, 89, 152));

            AlbumList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imágenes Agregadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
            AlbumList.setModel(new DefaultListModel());
            AlbumList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            jScrollPane18.setViewportView(AlbumList);

            AddPics.setText("Agregar Imágenes");
            AddPics.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    AddPicsMouseClicked(evt);
                }
            });

            AlbumTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del Álbum", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 8))); // NOI18N

            DescAlbum.setColumns(20);
            DescAlbum.setRows(5);
            DescAlbum.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 10))); // NOI18N
            jScrollPane19.setViewportView(DescAlbum);

            ShareAlbum.setText("Compartir");
            ShareAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ShareAlbumMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
            jPanel22.setLayout(jPanel22Layout);
            jPanel22Layout.setHorizontalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(AddPics, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlbumTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShareAlbum, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(18, Short.MAX_VALUE))
            );
            jPanel22Layout.setVerticalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                            .addComponent(AlbumTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34))
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddPics)
                        .addComponent(ShareAlbum))
                    .addContainerGap(15, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout AlbumLayout = new javax.swing.GroupLayout(Album.getContentPane());
            Album.getContentPane().setLayout(AlbumLayout);
            AlbumLayout.setHorizontalGroup(
                AlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            AlbumLayout.setVerticalGroup(
                AlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            PerfilPreview.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            PerfilPreview.setTitle("Perfil de Usuario");

            jPanel15.setBackground(new java.awt.Color(59, 89, 152));

            UserPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            UserPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            UserPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            UserPic.setOpaque(true);

            UserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            UserName.setForeground(new java.awt.Color(255, 255, 255));
            UserName.setText("Nombre del Usuario");

            jLabel68.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jLabel68.setForeground(new java.awt.Color(255, 255, 255));
            jLabel68.setText("Amigos");

            jLabel69.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jLabel69.setForeground(new java.awt.Color(255, 255, 255));
            jLabel69.setText("Publicaciones");

            ContAmigos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            ContAmigos.setForeground(new java.awt.Color(255, 255, 255));
            ContAmigos.setText("08");

            ContP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            ContP.setForeground(new java.awt.Color(255, 255, 255));
            ContP.setText("08");

            AddB.setText("Enviar Solicitud de Amistad");
            AddB.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    AddBMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
            jPanel15.setLayout(jPanel15Layout);
            jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(UserName)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(UserPic, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                            .addComponent(AddB)
                            .addGap(45, 45, 45))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel68)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(ContAmigos)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                    .addComponent(ContP)
                                    .addGap(27, 27, 27)))
                            .addGap(53, 53, 53))))
            );
            jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(UserName)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(UserPic, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                    .addComponent(ContAmigos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel68))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                    .addComponent(ContP)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel69)))
                            .addGap(31, 31, 31)
                            .addComponent(AddB)))
                    .addContainerGap(31, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout PerfilPreviewLayout = new javax.swing.GroupLayout(PerfilPreview.getContentPane());
            PerfilPreview.getContentPane().setLayout(PerfilPreviewLayout);
            PerfilPreviewLayout.setHorizontalGroup(
                PerfilPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            PerfilPreviewLayout.setVerticalGroup(
                PerfilPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            MyProfile.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            MyProfile.setTitle("Mi Perfil");

            jPanel18.setBackground(new java.awt.Color(59, 89, 152));

            UserPic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            UserPic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            UserPic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            UserPic1.setOpaque(true);

            UserName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            UserName1.setForeground(new java.awt.Color(255, 255, 255));
            UserName1.setText("Nombre del Usuario");

            ContAmigos1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            ContAmigos1.setForeground(new java.awt.Color(255, 255, 255));
            ContAmigos1.setText("08");

            jLabel70.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jLabel70.setForeground(new java.awt.Color(255, 255, 255));
            jLabel70.setText("Amigos");

            jLabel71.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
            jLabel71.setForeground(new java.awt.Color(255, 255, 255));
            jLabel71.setText("Publicaciones");

            ContP1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            ContP1.setForeground(new java.awt.Color(255, 255, 255));
            ContP1.setText("08");

            ChangePP.setText("Cambiar Foto de Perfil");
            ChangePP.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ChangePPMouseClicked(evt);
                }
            });

            mywall.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Fecha de Publicación", "Publicado Por", "Título", "Likes"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            mywall.setGridColor(new java.awt.Color(58, 89, 152));
            mywall.setRowHeight(40);
            mywall.setShowHorizontalLines(false);
            mywall.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    mywallMouseClicked(evt);
                }
            });
            jScrollPane28.setViewportView(mywall);

            javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
            jPanel18.setLayout(jPanel18Layout);
            jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                            .addComponent(UserPic1)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel18Layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel70)
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(ContAmigos1)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                            .addComponent(ContP1)
                                            .addGap(27, 27, 27)))
                                    .addGap(110, 110, 110))
                                .addGroup(jPanel18Layout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(ChangePP)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel18Layout.createSequentialGroup()
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel18Layout.createSequentialGroup()
                                    .addGap(174, 174, 174)
                                    .addComponent(UserName1)))
                            .addGap(0, 27, Short.MAX_VALUE))))
            );
            jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(UserPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel18Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(UserName1)
                            .addGap(40, 40, 40)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                    .addComponent(ContAmigos1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel70))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                    .addComponent(ContP1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel71)))
                            .addGap(26, 26, 26)
                            .addComponent(ChangePP)))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout MyProfileLayout = new javax.swing.GroupLayout(MyProfile.getContentPane());
            MyProfile.getContentPane().setLayout(MyProfileLayout);
            MyProfileLayout.setHorizontalGroup(
                MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            MyProfileLayout.setVerticalGroup(
                MyProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            Notifications.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            Notifications.setTitle("Solicitud de Amistad");

            jPanel16.setBackground(new java.awt.Color(59, 89, 152));

            notifs.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Usuario", "Notificación"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            notifs.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    notifsMouseClicked(evt);
                }
            });
            jScrollPane21.setViewportView(notifs);

            javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
            jPanel16.setLayout(jPanel16Layout);
            jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout NotificationsLayout = new javax.swing.GroupLayout(Notifications.getContentPane());
            Notifications.getContentPane().setLayout(NotificationsLayout);
            NotificationsLayout.setHorizontalGroup(
                NotificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            NotificationsLayout.setVerticalGroup(
                NotificationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            AllUsersPV.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            AllUsersPV.setTitle("Lista de Usuarios");

            jPanel14.setBackground(new java.awt.Color(59, 89, 152));

            FilterUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Tipos de Usuarios --", "Mis Amigos", "Todos los Usuarios" }));
            FilterUsuarios.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    FilterUsuariosItemStateChanged(evt);
                }
            });

            UsuariosLista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            UsuariosLista.setModel(new DefaultListModel());
            UsuariosLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            UsuariosLista.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    UsuariosListaMouseClicked(evt);
                }
            });
            jScrollPane20.setViewportView(UsuariosLista);

            javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
            jPanel14.setLayout(jPanel14Layout);
            jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(FilterUsuarios, 0, 190, Short.MAX_VALUE))
                    .addContainerGap(23, Short.MAX_VALUE))
            );
            jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(FilterUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout AllUsersPVLayout = new javax.swing.GroupLayout(AllUsersPV.getContentPane());
            AllUsersPV.getContentPane().setLayout(AllUsersPVLayout);
            AllUsersPVLayout.setHorizontalGroup(
                AllUsersPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            AllUsersPVLayout.setVerticalGroup(
                AllUsersPVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            ViewStatus.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            ViewStatus.setTitle("Nuevo Estado");

            jPanel23.setBackground(new java.awt.Color(59, 89, 152));
            jPanel23.setForeground(new java.awt.Color(59, 89, 152));

            NewStatus1.setEditable(false);
            NewStatus1.setColumns(20);
            NewStatus1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            NewStatus1.setRows(5);
            jScrollPane23.setViewportView(NewStatus1);

            namepost.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
            namepost.setForeground(new java.awt.Color(255, 255, 255));
            namepost.setText("Nombre");

            LikePost.setText("Me Gusta");
            LikePost.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    LikePostMouseClicked(evt);
                }
            });

            CommentPost.setText("Comentar");
            CommentPost.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    CommentPostMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
            jPanel23.setLayout(jPanel23Layout);
            jPanel23Layout.setHorizontalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane23)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addComponent(namepost, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 207, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(LikePost)
                            .addGap(18, 18, 18)
                            .addComponent(CommentPost)))
                    .addContainerGap())
            );
            jPanel23Layout.setVerticalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(namepost, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LikePost)
                        .addComponent(CommentPost))
                    .addContainerGap())
            );

            javax.swing.GroupLayout ViewStatusLayout = new javax.swing.GroupLayout(ViewStatus.getContentPane());
            ViewStatus.getContentPane().setLayout(ViewStatusLayout);
            ViewStatusLayout.setHorizontalGroup(
                ViewStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            ViewStatusLayout.setVerticalGroup(
                ViewStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            ViewPicture.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            ViewPicture.setTitle("Ver Imagen");

            jPanel24.setBackground(new java.awt.Color(59, 89, 152));

            PreviewPic1.setBackground(new java.awt.Color(255, 255, 255));
            PreviewPic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            PreviewPic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            PreviewPic1.setOpaque(true);

            DescPic1.setEditable(false);
            DescPic1.setColumns(20);
            DescPic1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            DescPic1.setRows(5);
            DescPic1.setText("\n");
            jScrollPane24.setViewportView(DescPic1);

            commentp.setText("Comentar");
            commentp.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    commentpMouseClicked(evt);
                }
            });

            likep.setText("Me Gusta");
            likep.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    likepMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
            jPanel24.setLayout(jPanel24Layout);
            jPanel24Layout.setHorizontalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                    .addGap(0, 19, Short.MAX_VALUE)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(commentp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(80, 80, 80)
                    .addComponent(likep, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PreviewPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(74, 74, 74))
            );
            jPanel24Layout.setVerticalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(PreviewPic1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(commentp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(likep, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(20, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout ViewPictureLayout = new javax.swing.GroupLayout(ViewPicture.getContentPane());
            ViewPicture.getContentPane().setLayout(ViewPictureLayout);
            ViewPictureLayout.setHorizontalGroup(
                ViewPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            ViewPictureLayout.setVerticalGroup(
                ViewPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewPictureLayout.createSequentialGroup()
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            ViewAlbum.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            ViewAlbum.setTitle("Ver Álbum");

            jPanel25.setBackground(new java.awt.Color(59, 89, 152));

            AddPics1.setText("Comentar");
            AddPics1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    AddPics1MouseClicked(evt);
                }
            });

            albmt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del Álbum", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 8))); // NOI18N

            albmdesc.setColumns(20);
            albmdesc.setRows(5);
            albmdesc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 10))); // NOI18N
            jScrollPane26.setViewportView(albmdesc);

            ShareAlbum1.setText("Me Gusta");
            ShareAlbum1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    ShareAlbum1MouseClicked(evt);
                }
            });

            pic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            pic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            pic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            pic1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    pic1MouseClicked(evt);
                }
            });

            pic2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            pic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            pic2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            pic2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    pic2MouseClicked(evt);
                }
            });

            pic3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            pic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            pic3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            pic3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    pic3MouseClicked(evt);
                }
            });

            pic4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            pic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png"))); // NOI18N
            pic4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            pic4.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    pic4MouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
            jPanel25.setLayout(jPanel25Layout);
            jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pic3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pic1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pic4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                    .addComponent(AddPics1)
                                    .addGap(18, 18, 18)
                                    .addComponent(ShareAlbum1)
                                    .addGap(23, 23, 23))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                    .addComponent(albmt, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())))))
            );
            jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(albmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ShareAlbum1)
                        .addComponent(AddPics1))
                    .addGap(24, 24, 24))
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pic3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pic4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(43, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout ViewAlbumLayout = new javax.swing.GroupLayout(ViewAlbum.getContentPane());
            ViewAlbum.getContentPane().setLayout(ViewAlbumLayout);
            ViewAlbumLayout.setHorizontalGroup(
                ViewAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            ViewAlbumLayout.setVerticalGroup(
                ViewAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ViewAlbumLayout.createSequentialGroup()
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            View.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/full.png"))); // NOI18N
            View.setText("Ver Publicación");
            View.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ViewActionPerformed(evt);
                }
            });
            PMPosts.add(View);

            IndPic.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            IndPic.setTitle("Visor de Imágenes");

            jPanel17.setBackground(new java.awt.Color(59, 89, 152));

            mainpicv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            mainpicv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
            jPanel17.setLayout(jPanel17Layout);
            jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainpicv, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainpicv, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout IndPicLayout = new javax.swing.GroupLayout(IndPic.getContentPane());
            IndPic.getContentPane().setLayout(IndPicLayout);
            IndPicLayout.setHorizontalGroup(
                IndPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            IndPicLayout.setVerticalGroup(
                IndPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Windows Simulator");
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            setMaximumSize(new java.awt.Dimension(1043, 680));
            setMinimumSize(new java.awt.Dimension(1043, 680));
            setPreferredSize(new java.awt.Dimension(1043, 680));
            setResizable(false);
            setSize(new java.awt.Dimension(1043, 680));
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    PopUpMenu(evt);
                }
            });
            getContentPane().setLayout(null);

            MainMenu.setBackground(new java.awt.Color(245, 221, 221));
            MainMenu.setForeground(new java.awt.Color(204, 204, 255));
            MainMenu.setRollover(true);

            archives.setBackground(new java.awt.Color(245, 221, 221));
            archives.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Archivos.png"))); // NOI18N
            archives.setFocusable(false);
            archives.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            archives.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            archives.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    archivesMouseClicked(evt);
                }
            });
            archives.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    archivesActionPerformed(evt);
                }
            });
            MainMenu.add(archives);

            console.setBackground(new java.awt.Color(245, 221, 221));
            console.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consola.png"))); // NOI18N
            console.setFocusable(false);
            console.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            console.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            console.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    consoleMouseClicked(evt);
                }
            });
            MainMenu.add(console);
            MainMenu.add(jSeparator1);

            texteditor.setBackground(new java.awt.Color(245, 221, 221));
            texteditor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Texto.png"))); // NOI18N
            texteditor.setFocusable(false);
            texteditor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            texteditor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            texteditor.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    texteditorMouseClicked(evt);
                }
            });
            MainMenu.add(texteditor);

            calendar.setBackground(new java.awt.Color(245, 221, 221));
            calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Calendario.png"))); // NOI18N
            calendar.setFocusable(false);
            calendar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            calendar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            calendar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    calendarMouseClicked(evt);
                }
            });
            MainMenu.add(calendar);

            netbeans.setBackground(new java.awt.Color(245, 221, 221));
            netbeans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NetBeans.png"))); // NOI18N
            netbeans.setFocusable(false);
            netbeans.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            netbeans.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            netbeans.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    netbeansMouseClicked(evt);
                }
            });
            MainMenu.add(netbeans);
            MainMenu.add(jSeparator2);

            images.setBackground(new java.awt.Color(245, 221, 221));
            images.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen.png"))); // NOI18N
            images.setFocusable(false);
            images.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            images.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            images.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    imagesMouseClicked(evt);
                }
            });
            MainMenu.add(images);

            music.setBackground(new java.awt.Color(245, 221, 221));
            music.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Musica.png"))); // NOI18N
            music.setFocusable(false);
            music.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            music.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            music.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    musicMouseClicked(evt);
                }
            });
            MainMenu.add(music);
            MainMenu.add(jSeparator3);

            socials.setBackground(new java.awt.Color(245, 221, 221));
            socials.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fb (3).png"))); // NOI18N
            socials.setFocusable(false);
            socials.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            socials.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            socials.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    socialsMouseClicked(evt);
                }
            });
            MainMenu.add(socials);

            im.setBackground(new java.awt.Color(245, 221, 221));
            im.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Messenger.png"))); // NOI18N
            im.setFocusable(false);
            im.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            im.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            im.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    imMouseClicked(evt);
                }
            });
            MainMenu.add(im);
            MainMenu.add(jSeparator4);

            recycle.setBackground(new java.awt.Color(245, 221, 221));
            recycle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reciclaje.png"))); // NOI18N
            recycle.setFocusable(false);
            recycle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            recycle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            recycle.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    recycleMouseClicked(evt);
                }
            });
            recycle.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    recycleActionPerformed(evt);
                }
            });
            MainMenu.add(recycle);

            getContentPane().add(MainMenu);
            MainMenu.setBounds(200, 570, 610, 60);

            Time.setBackground(new java.awt.Color(255, 255, 255));
            Time.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            Time.setText("00:00");
            Time.setOpaque(true);
            getContentPane().add(Time);
            Time.setBounds(970, 610, 80, 20);

            BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/KjyvQ6I.jpg"))); // NOI18N
            getContentPane().add(BG);
            BG.setBounds(0, 0, 1050, 630);

            File.setText("File");

            m_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Home.png"))); // NOI18N
            m_admin.setText("Administrador");
            m_admin.setEnabled(false);
            m_admin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

            m_newuser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
            m_newuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/newuser.png"))); // NOI18N
            m_newuser.setText("Nuevo Usuario");
            m_newuser.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newuserActionPerformed(evt);
                }
            });
            m_admin.add(m_newuser);

            m_allusers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adminu.png"))); // NOI18N
            m_allusers.setText("Administrar Usuarios");
            m_allusers.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_allusersActionPerformed(evt);
                }
            });
            m_admin.add(m_allusers);

            File.add(m_admin);

            m_ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit p.png"))); // NOI18N
            m_ajustes.setText("Ajustes");

            m_newname.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
            m_newname.setText("Cambiar Display Name");
            m_newname.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newnameActionPerformed(evt);
                }
            });
            m_ajustes.add(m_newname);

            m_bday.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
            m_bday.setText("Cambiar Cumpleaños");
            m_bday.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_bdayActionPerformed(evt);
                }
            });
            m_ajustes.add(m_bday);

            m_email.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
            m_email.setText("Cambiar Correo Electrónico");
            m_email.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_emailActionPerformed(evt);
                }
            });
            m_ajustes.add(m_email);

            m_newun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
            m_newun.setText("Cambiar Nombre de Usuario");
            m_newun.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newunActionPerformed(evt);
                }
            });
            m_ajustes.add(m_newun);

            m_newpw.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
            m_newpw.setText("Cambiar Contraseña");
            m_newpw.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_newpwActionPerformed(evt);
                }
            });
            m_ajustes.add(m_newpw);

            File.add(m_ajustes);

            m_lock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
            m_lock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lock (7).png"))); // NOI18N
            m_lock.setText("Bloquear");
            m_lock.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_lockActionPerformed(evt);
                }
            });
            File.add(m_lock);

            m_logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
            m_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
            m_logout.setText("Log Out");
            m_logout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_logoutActionPerformed(evt);
                }
            });
            File.add(m_logout);

            MenuPrincipal.add(File);

            Edit.setText("Edit");

            m_changebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgc.png"))); // NOI18N
            m_changebg.setText("Cambiar Fondo de Pantalla");
            m_changebg.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_changebgActionPerformed(evt);
                }
            });
            Edit.add(m_changebg);

            m_changecolor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bg.png"))); // NOI18N
            m_changecolor.setText("Cambiar Color del Sistema");
            m_changecolor.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    m_changecolorActionPerformed(evt);
                }
            });
            Edit.add(m_changecolor);

            MenuPrincipal.add(Edit);

            Help.setText("Help");

            helpicons.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
            helpicons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/List.png"))); // NOI18N
            helpicons.setText("Ayuda Íconos");
            helpicons.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    helpiconsActionPerformed(evt);
                }
            });
            Help.add(helpicons);

            MenuPrincipal.add(Help);

            blankspace.setText("                                                                                                                                                                                                                                                                                                       ");
            blankspace.setEnabled(false);
            MenuPrincipal.add(blankspace);

            Date.setText("Date");
            Date.setEnabled(false);
            Date.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
            MenuPrincipal.add(Date);

            setJMenuBar(MenuPrincipal);

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void PopUpMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PopUpMenu
        if (evt.isMetaDown()) {
            PopUpMain.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_PopUpMenu

    private void m_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_helpActionPerformed
        Icons.setVisible(true);
        Icons.setLocationRelativeTo(null);
    }//GEN-LAST:event_m_helpActionPerformed

    private void m_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_logoutActionPerformed
        m_admin.setEnabled(false);
        TreeArchives.setModel(null);
        ((DefaultTableModel) TableArchives.getModel()).setRowCount(0);
        setVisible(false);
        LogIn.setVisible(true);
        LogIn.setLocationRelativeTo(null);
    }//GEN-LAST:event_m_logoutActionPerformed

    private void m_changebgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changebgActionPerformed
        JFileChooser FChooser = new JFileChooser();
        FileFilter Filter = new FileNameExtensionFilter("Imágenes",
                "png", "jpg", "jpeg", "gif");
        FChooser.setFileFilter(Filter);
        File archive = null;
        int op = FChooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            archive = FChooser.getSelectedFile();
        }
        ImageIcon newBG = new ImageIcon(archive.getPath());
        BG.setIcon(newBG);
        JOptionPane.showMessageDialog(this, "¡Cambios aplicados exitósamente!");
    }//GEN-LAST:event_m_changebgActionPerformed

    private void m_changecolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changecolorActionPerformed
        Color C = JColorChooser.showDialog(this, "Seleccione un nuevo color para el sistema.", Color.yellow);
        MainMenu.setBackground(C);
        archives.setBackground(C);
        console.setBackground(C);
        im.setBackground(C);
        images.setBackground(C);
        music.setBackground(C);
        netbeans.setBackground(C);
        socials.setBackground(C);
        texteditor.setBackground(C);
        calendar.setBackground(C);
        recycle.setBackground(C);
        USER.setC(C);
        Time.setBackground(C);
        MusicPB.setForeground(C);
    }//GEN-LAST:event_m_changecolorActionPerformed

    private void m_bdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_bdayActionPerformed
        NewBDay.setVisible(true);
        NewBDay.setLocationRelativeTo(this);
    }//GEN-LAST:event_m_bdayActionPerformed

    private void m_lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_lockActionPerformed
        LockUser.setLocationRelativeTo(null);
        LockUser.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_m_lockActionPerformed

    private void m_newnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newnameActionPerformed
        File f = new File("./Sistema/" + USER.getNombre());
        USER.setNombre(JOptionPane.showInputDialog(this, "Ingrese un nuevo nombre: "));
        f.renameTo(new File("./Sistema/" + USER.getNombre()));
        JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente.");
    }//GEN-LAST:event_m_newnameActionPerformed

    private void m_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_emailActionPerformed
        boolean v = false;
        while (v == false) {
            try {
                USER.setCorreo(JOptionPane.showInputDialog(this, "Ingrese un nuevo correo electrónico: "));
                JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente!");
                v = true;
            } catch (Exceptions x) {
                JOptionPane.showMessageDialog(this, x);
            }
        }
    }//GEN-LAST:event_m_emailActionPerformed

    private void m_newunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newunActionPerformed
        boolean v = false;
        while (v == false) {
            try {
                USER.setUsername(JOptionPane.showInputDialog(this, "Ingrese un nuevo nombre de usuario: "));
                JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente!");
                v = true;
            } catch (Exceptions x) {
                JOptionPane.showMessageDialog(this, x);
            }
        }
    }//GEN-LAST:event_m_newunActionPerformed

    private void m_newpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newpwActionPerformed
        boolean v = false;
        while (v == false) {
            try {
                USER.setPW(JOptionPane.showInputDialog(this, "Ingrese un nueva contraseña: "));
                JOptionPane.showMessageDialog(this, "¡Cambio realizado exitósamente!");
                v = true;
            } catch (Exceptions x) {
                JOptionPane.showMessageDialog(this, x);
            }
        }
    }//GEN-LAST:event_m_newpwActionPerformed

    private void SaveBDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveBDayMouseClicked
        USER.setBday(CalendarBday.getDate());
        JOptionPane.showMessageDialog(this, "¡Fecha cambiada exitósamente!");
        NewBDay.setVisible(false);
    }//GEN-LAST:event_SaveBDayMouseClicked

    private void recycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recycleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recycleActionPerformed

    private void b_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_loginMouseClicked
        String un = jt_userlogin.getText();
        String pw = pf_pwlogin.getText();
        for (Usuario U : Users) {
            if (U.getUsername().equalsIgnoreCase(un) && U.getPW().equals(pw)) {
                USER = U;
                Color C = USER.getC();
                MainMenu.setBackground(C);
                archives.setBackground(C);
                console.setBackground(C);
                im.setBackground(C);
                images.setBackground(C);
                music.setBackground(C);
                netbeans.setBackground(C);
                socials.setBackground(C);
                texteditor.setBackground(C);
                calendar.setBackground(C);
                recycle.setBackground(C);
                SaveNewU.setBackground(C);
                Time.setBackground(C);
                MusicPB.setForeground(C);
                //set jtree de navegador
                if (USER instanceof Administrador) {
                    m_admin.setEnabled(true);
                }
                jt_userlogin.setText("");
                pf_pwlogin.setText("");
                pf_pwlogin.setBackground(Color.WHITE);
                namelockscreen.setText(USER.getNombre());
                LogIn.setVisible(false);
                this.setVisible(true);
                this.setLocationRelativeTo(null);
                if (USER.isMsn()) {
                    int resp = JOptionPane.showConfirmDialog(this, "¡Tiene un mensaje nuevo!\n¿Desea leerlo ahora?");
                    if (resp == JOptionPane.YES_OPTION) {
                        Messenger.pack();
                        Messenger.setLocationRelativeTo(null);
                        Messenger.setVisible(true);
                    }
                    USER.setMsn(false);
                }
                break;
            } else if (U.getUsername().equalsIgnoreCase(un) && (!U.getPW().equals(pw))) {
                pf_pwlogin.setBackground(Color.pink);
                JOptionPane.showMessageDialog(LogIn, "Contraseña incorrecta.\nInténtelo de nuevo.");
                pf_pwlogin.setText("");
                break;
            } else if (Users.indexOf(U) == Users.size() - 1 && (!U.getNombre().equals(un))) {
                JOptionPane.showMessageDialog(LogIn, "El usuario ingresado no existe.\nInténtelo de nuevo con otro usuario o contacte el administrador del equipo.");
                jt_userlogin.setText("");
                pf_pwlogin.setText("");
            }

        }
    }//GEN-LAST:event_b_loginMouseClicked

    private void b_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_cancelMouseClicked
        jt_userlogin.setText("");
        pf_pwlogin.setText("");
    }//GEN-LAST:event_b_cancelMouseClicked

    private void b_shutdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_shutdownMouseClicked
        int resp = JOptionPane.showConfirmDialog(this, "¿Desea salir del Sistema?");
        if (resp == JOptionPane.YES_OPTION) {
            RecycleBinTable.removeAll();
            File RB = new File("./Papelera de Reciclaje");
            for (File f : RB.listFiles()) {
                f.delete();
            }
            BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
            BAA.loadArchive();
            BAA.setUsers(Users);
            BAA.overrideArchive();
            System.exit(0);
        }
    }//GEN-LAST:event_b_shutdownMouseClicked

    private void jb_forgotpwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_forgotpwMouseClicked
        String UN = JOptionPane.showInputDialog(LogIn, "Ingrese su nombre de usuario:");
        String Pregunta = "";
        for (Usuario User : Users) {
            if (User.getUsername().equalsIgnoreCase(UN)) {
                JOptionPane.showMessageDialog(LogIn, "Para recuperar su contraseña, es necesario que responda correctamente la pregunta de seguridad.");
                Pregunta = User.getPregunta();
                String Resp = JOptionPane.showInputDialog(LogIn, Pregunta);
                if (Resp.equalsIgnoreCase(User.getRespPW())) {
                    JOptionPane.showMessageDialog(LogIn, "Su contraseña es: " + User.getPW());
                } else {
                    JOptionPane.showMessageDialog(LogIn, "Respuesta incorrecta. \nInténtelo de nuevo.");
                }
                break;
            }
            if (Users.indexOf(User) == Users.size() - 1) {
                JOptionPane.showMessageDialog(LogIn, "El nombre de usuario ingresado no se encuentra registrado.");
            }
        }
    }//GEN-LAST:event_jb_forgotpwMouseClicked

    private void m_changecolor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changecolor1ActionPerformed
        Color C = JColorChooser.showDialog(null, "Seleccione un nuevo color para el sistema.", Color.yellow);
        USER.setC(C);
        MainMenu.setBackground(C);
        archives.setBackground(C);
        console.setBackground(C);
        im.setBackground(C);
        images.setBackground(C);
        music.setBackground(C);
        netbeans.setBackground(C);
        socials.setBackground(C);
        texteditor.setBackground(C);
        calendar.setBackground(C);
        recycle.setBackground(C);
        SaveNewU.setBackground(C);
        Time.setBackground(C);
        MusicPB.setForeground(C);
    }//GEN-LAST:event_m_changecolor1ActionPerformed

    private void helpiconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpiconsActionPerformed
        Icons.pack();
        Icons.setLocationRelativeTo(this);
        Icons.setVisible(true);

    }//GEN-LAST:event_helpiconsActionPerformed

    private void archivesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archivesMouseClicked
        Archives.pack();
        Archives.setLocationRelativeTo(this);
        Archives.setVisible(true);
        TreeArchives.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        DefaultTreeModel m = (DefaultTreeModel) TreeArchives.getModel();
        DefaultTableModel m2 = (DefaultTableModel) TableArchives.getModel();
        m.setRoot(new DefaultMutableTreeNode("Sistema"));

        if (USER instanceof Administrador) {
            DefaultMutableTreeNode Root = (DefaultMutableTreeNode) m.getRoot();
            SetTrees(new File("./Sistema/"), Root);
            m.reload();
        } else {

            if (!flag) {
                m.setRoot(new DefaultMutableTreeNode("Sistema"));
                flag = true;
            }

            DefaultMutableTreeNode Root = new DefaultMutableTreeNode(m.getRoot().toString());
            DefaultMutableTreeNode Child = new DefaultMutableTreeNode(USER.getNombre());
            Root.add(Child);
            m.setRoot(Root);
            SetTrees(new File("./Sistema/" + USER.getNombre()), Child);
            m.reload();
        }
        m2.setRowCount(0);
    }//GEN-LAST:event_archivesMouseClicked

    private void consoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consoleMouseClicked
        currentpath = "./Sistema/" + USER.getNombre();
        pathaesthetic = "Sistema:\\\\" + USER.getNombre() + ">";
        ConsoleText.append("Mini Windows [Versión 1.00]\n"
                + "(c) 2018 Andrea J. Mendoza. Todos los derechos reservados.\n\nSistema:\\" + USER.getNombre() + ">");
        Console.pack();
        Console.setLocationRelativeTo(this);
        Console.setVisible(true);
    }//GEN-LAST:event_consoleMouseClicked

    private void texteditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texteditorMouseClicked
        txt.setContentType("text/html");
        TextEditor.pack();
        TextEditor.setLocationRelativeTo(this);
        TextEditor.setVisible(true);
    }//GEN-LAST:event_texteditorMouseClicked

    private void calendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarMouseClicked
        Agenda.pack();
        Agenda.setLocationRelativeTo(this);
        Agenda.setVisible(true);

    }//GEN-LAST:event_calendarMouseClicked

    private void netbeansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_netbeansMouseClicked
        Netbeans.pack();
        Netbeans.setLocationRelativeTo(this);
        Netbeans.setVisible(true);

    }//GEN-LAST:event_netbeansMouseClicked

    private void imagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagesMouseClicked
        I.removeAll(I); //*
        Images.getContentPane().setBackground(Color.WHITE);
        File Imagenes = new File("./Sistema/" + USER.getNombre() + USER.getCImagenes());
        if (Imagenes.listFiles().length <= 0) {
            JOptionPane.showMessageDialog(this, "No se han encontrado imágenes asociadas a su carpeta."
                    + "\nAgregue archivos para poder visualizarlos correctamente.");
            try {
                JFileChooser FChooser = new JFileChooser();
                FileFilter Filter;
                Filter = new FileNameExtensionFilter("Imágenes",
                        "png", "jpg", "jpeg", "gif");
                FChooser.setFileFilter(Filter);
                File archive;
                int op = FChooser.showOpenDialog(this);
                if (op == JFileChooser.APPROVE_OPTION) {
                    archive = FChooser.getSelectedFile();
                    Image img = Toolkit.getDefaultToolkit().createImage(
                            archive.getPath());
                    I.add(img);
                    Files.copy(Paths.get(archive.getPath()),
                            Paths.get("./Sistema/"
                                    + USER.getNombre()
                                    + USER.getCImagenes() + "/"
                                    + archive.getName()),
                            StandardCopyOption.REPLACE_EXISTING);
                }
                ImageIcon imageIcon = new ImageIcon(I.get(0));
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);
                MainImage.setIcon(imageIcon);
            } catch (Exception e) {
            }
        } else {
            for (int i = 0; i < Imagenes.listFiles().length; i++) {
                Image ig = Toolkit.getDefaultToolkit().createImage(Imagenes.listFiles()[i].getPath());
                I.add(ig);
                if (i < 3) {
                    if (I.size() >= 3) {
                        ig1 = I.get(pos1);
                        ig2 = I.get(pos2);
                        ig3 = I.get(pos3);
                        ig4 = ig1.getScaledInstance(190, 122, 0);
                        ig5 = ig2.getScaledInstance(190, 122, 0);
                        ig6 = ig3.getScaledInstance(190, 122, 0);
                        Icon1.setIcon(new ImageIcon(ig4));
                        Icon2.setIcon(new ImageIcon(ig5));
                        Icon3.setIcon(new ImageIcon(ig6));
                        i1 = true;
                        i2 = true;
                        i3 = true;
                    } else if (I.size() == 1) {
                        ig1 = I.get(pos1);
                        ig4 = ig1.getScaledInstance(190, 122, 0);
                        Icon1.setIcon(new ImageIcon(ig4));
                        i1 = true;
                    } else if (I.size() == 2) {
                        ig1 = I.get(pos1);
                        ig2 = I.get(pos2);
                        ig4 = ig1.getScaledInstance(190, 122, 0);
                        ig5 = ig2.getScaledInstance(190, 122, 0);
                        Icon1.setIcon(new ImageIcon(ig4));
                        Icon2.setIcon(new ImageIcon(ig5));
                        i1 = true;
                        i2 = true;
                    }
                }
            }
            ImageIcon imageIcon = new ImageIcon(ig1);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            MainImage.setIcon(imageIcon);
        }
        Images.pack();
        Images.setLocationRelativeTo(this);
        Images.setVisible(true);
    }//GEN-LAST:event_imagesMouseClicked

    private void musicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicMouseClicked
        bm.start();
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
        DefaultListModel m = (DefaultListModel) Playlist.getModel();
        m.removeAllElements();
        MusicPaths = new ArrayList();
        File Music = new File("./Sistema/" + USER.getNombre() + USER.getCMusica());
        for (int i = 1; i < Music.listFiles().length + 1; i++) {
            if (Music.listFiles()[i - 1].getName().contains("mp3")) {
                MusicPaths.add(Music.listFiles()[i - 1].getPath());
                m.addElement(i + ".-  " + Music.listFiles()[i - 1].getName() + "\n");
            }
        }
        Playlist.setModel(m);
        MusicPlayer.pack();
        MusicPlayer.setLocationRelativeTo(this);
        MusicPlayer.setVisible(true);

    }//GEN-LAST:event_musicMouseClicked

    private void imMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imMouseClicked
        DefaultListModel m = (DefaultListModel) Contacts.getModel();
        m.removeAllElements();
        for (Usuario U : Users) {
            m.addElement(U);
        }
        Messenger.pack();
        Messenger.setLocationRelativeTo(this);
        Messenger.setVisible(true);
    }//GEN-LAST:event_imMouseClicked

    private void socialsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_socialsMouseClicked
        DefaultTableModel m = (DefaultTableModel) Wall.getModel();
        m.setRowCount(0);
        RefreshGeneralWall();
        Home.pack();
        Home.setLocationRelativeTo(this);
        Home.setVisible(true);

    }//GEN-LAST:event_socialsMouseClicked

    private void recycleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recycleMouseClicked

        RecycleBin.pack();
        RecycleBin.setLocationRelativeTo(this);
        RecycleBin.setVisible(true);

    }//GEN-LAST:event_recycleMouseClicked

    private void m_newuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_newuserActionPerformed
        NewUser.pack();
        NewUser.setLocationRelativeTo(this);
        NewUser.setVisible(true);
    }//GEN-LAST:event_m_newuserActionPerformed

    private void SaveNewUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveNewUMouseClicked
        Usuario U;
        try {
            U = new Usuario(tf_newuname.getText(),
                    (Integer) s_edad.getValue(),
                    jd_newbday.getDate(),
                    tf_newunuser.getText(),
                    tf_newunpw.getText(),
                    tf_newunanswer.getText(),
                    tf_newuemail.getText(),
                    cb_question.getSelectedItem().toString(),
                    color.getBackground());
            UNs.add(tf_newunuser.getText());
            CreateSubDirs(U.getNombre());
            NewUser.setVisible(false);
            BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
            BAA.loadArchive();
            BAA.setUsuario(U);
            Users = BAA.getUsers();
            BAA.overrideArchive();
            Admin.setUsuarios(Users);

            Dba db = new Dba("./TheSN.accdb");
            db.conectar();
            try {
                db.query.execute("INSERT INTO Usuarios"
                        + " (Nombre)"
                        + " VALUES ('" + tf_newunuser.getText() + "')");
                db.commit();
            } catch (SQLException ex) {
            }
            db.desconectar();

            JOptionPane.showMessageDialog(this, "¡Usuario creado exitósamente!");
        } catch (Exceptions e) {
            switch (e.getMessage()) {
                case "El nombre de usuario ingresado no está disponible.\nInténtelo de nuevo.":
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    tf_newunuser.setForeground(Color.RED);
                    break;
                case "Contraseña Inválida.\nIngrese una nueva contraseña con al menos un número y una letra mayúscula.":
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    tf_newunpw.setForeground(Color.RED);
                    break;
                case "El texto ingresado no es un correo.\nInténtelo de nuevo.":
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    tf_newuemail.setForeground(Color.RED);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error desconocido. Inténtelo de nuevo.");
                    break;
            }
        }
    }//GEN-LAST:event_SaveNewUMouseClicked

    private void ClearField(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearField
        tf_newuname.setText("");
    }//GEN-LAST:event_ClearField

    private void tf_newunpwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newunpwMouseClicked
        tf_newunpw.setText("");
    }//GEN-LAST:event_tf_newunpwMouseClicked

    private void tf_newunuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newunuserMouseClicked
        tf_newunuser.setText("");
    }//GEN-LAST:event_tf_newunuserMouseClicked

    private void tf_newunanswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newunanswerMouseClicked
        tf_newunanswer.setText("");
    }//GEN-LAST:event_tf_newunanswerMouseClicked

    private void tf_newuemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_newuemailMouseClicked
        tf_newuemail.setText("");
    }//GEN-LAST:event_tf_newuemailMouseClicked

    private void estcolorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estcolorMouseClicked
        color.setBackground(JColorChooser.showDialog(this, "Seleccione un color predeterminado para el Sistema", Color.yellow));
    }//GEN-LAST:event_estcolorMouseClicked

    private void lockscreenpwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lockscreenpwMouseClicked
        warning.setVisible(false);
    }//GEN-LAST:event_lockscreenpwMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (USER.getPW().equals(lockscreenpw.getText())) {
            LockUser.setVisible(false);
            this.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void m_allusersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_allusersActionPerformed
        File Origin = new File("./Sistema");
        SetTrees(Origin, (DefaultMutableTreeNode) MainTree.getModel().getRoot());
        AdministrarUsuarios.pack();
        AdministrarUsuarios.setLocationRelativeTo(null);
        AdministrarUsuarios.setVisible(true);
    }//GEN-LAST:event_m_allusersActionPerformed

    private void AddImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddImagesActionPerformed
// aqui tira error pero idk why
        try {
            JFileChooser FChooser = new JFileChooser();
            FileFilter Filter;

            Filter = new FileNameExtensionFilter("Imágenes",
                    "png", "jpg", "jpeg", "gif");
            FChooser.setFileFilter(Filter);
            File archive;
            int op = FChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archive = FChooser.getSelectedFile();
                Image img = Toolkit.getDefaultToolkit().createImage(
                        archive.getPath()).getScaledInstance(-1, 373, 0);
                I.add(img);
                Files.copy(Paths.get(archive.getPath()),
                        Paths.get("./Sistema/"
                                + USER.getNombre()
                                + USER.getCImagenes() + "/"
                                + archive.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
        }
        if (i1 == false) {
            Icon1.setIcon((I.get(I.size() - 1)));

        } else if (i2 == false) {
            Icon2.setIcon((I.get(I.size() - 1)));
        } else if (i3 == false) {
            Icon3.setIcon((I.get(I.size() - 1)));
        }

    }//GEN-LAST:event_AddImagesActionPerformed

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        if (evt.isMetaDown()) {
            this.ArchivesPM.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jScrollPane5MouseClicked

    private void TableArchivesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableArchivesMouseClicked
        DefaultTableModel m = (DefaultTableModel) TableArchives.getModel();
        String temp = "./";
        if (TableArchives.getSelectedRow() > -1) {
            if (evt.isMetaDown()) {
                ArchivesPM.show(TableArchives, evt.getX(), evt.getY());
                try {
                    for (Object object : TreeArchives.getSelectionPath().getPath()) {
                        temp += object.toString() + "/";
                    }
                } catch (Exception e) {
                    System.out.println("error " + temp);
                }
                modifiedpath = temp.substring(0, temp.length() - 1) + "/" + m.getValueAt(TableArchives.getSelectedRow(), 0);
                if (Paste.isEnabled()) {
                    modifiedpath2 = temp.substring(0, modifiedpath.length());
                }
                System.out.println("path1 " + modifiedpath);
                System.out.println("path2 " + modifiedpath2);
                Modified = new File(modifiedpath);
            }
        }
    }//GEN-LAST:event_TableArchivesMouseClicked

    private void TreeArchivesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreeArchivesMouseClicked
        DefaultTableModel m2 = (DefaultTableModel) TableArchives.getModel();
        m2.setRowCount(0);

        TreeArchives.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent tse) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) TreeArchives.getLastSelectedPathComponent();
            }
        });
        String tipo = "";
        File f;
        try {
            for (Object object : TreeArchives.getSelectionPath().getPath()) {
                path += object.toString() + "/";
            }
        } catch (Exception e) {
        }
        path = path.substring(0, path.length() - 1);
        f = new File(path);
        if (f.listFiles() != null) {
            ArrayList<File> Folder = new ArrayList(Arrays.asList(f.listFiles()));
            for (File file : Folder) {
                try {
                    BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
                    if (file.getName().contains(".")) {
                        tipo = "Archivo " + file.getName().substring(file.getName().lastIndexOf("."));
                    } else {
                        tipo = "Carpeta de Archivos";
                    }
                    Object[] Directories = {file.getName(), attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
                    m2.addRow(Directories);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar localizar el archivo.");
                }

                TableArchives.setModel(m2);
            }
            path = "./";
        } else {
            try {
                BasicFileAttributes attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                if (f.getName().contains(".")) {
                    tipo = "Archivo " + f.getName().substring(f.getName().lastIndexOf("."));
                } else {
                    tipo = "Carpeta de Archivos";
                }
                Object[] Directories = {f.getName(), attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
                m2.addRow(Directories);

                TableArchives.setModel(m2);

            } catch (Exception ex) {
                Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
            }
            path = "./";
        }
        if (Paste.isEnabled()) {
            if (evt.isMetaDown()) {
                ArchivesPM.show(TreeArchives, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_TreeArchivesMouseClicked

    private void archivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_archivesActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (pos3 == I.size() - 1) {
            jButton2.setEnabled(false);
        } else {
            ++pos1;
            ++pos2;
            ++pos3;
            ig1 = I.get(pos1);
            ig2 = I.get(pos2);
            ig3 = I.get(pos3);
            ig4 = ig1.getScaledInstance(190, 122, 0);
            ig5 = ig2.getScaledInstance(190, 122, 0);
            ig6 = ig3.getScaledInstance(190, 122, 0);
            Icon1.setIcon(new ImageIcon(ig4));
            Icon2.setIcon(new ImageIcon(ig5));
            Icon3.setIcon(new ImageIcon(ig6));
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void Icon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icon1MouseClicked
        ImageIcon imageIcon = new ImageIcon(ig1);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        MainImage.setIcon(imageIcon);
    }//GEN-LAST:event_Icon1MouseClicked

    private void Icon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icon2MouseClicked
        ImageIcon imageIcon = new ImageIcon(ig2);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        MainImage.setIcon(imageIcon);
    }//GEN-LAST:event_Icon2MouseClicked

    private void Icon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icon3MouseClicked
        ImageIcon imageIcon = new ImageIcon(ig3);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 373, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        MainImage.setIcon(imageIcon);
    }//GEN-LAST:event_Icon3MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if (pos1 == 0) {
            jButton3.setEnabled(false);
        } else {
            --pos1;
            --pos2;
            --pos3;
            ig1 = I.get(pos1);
            ig2 = I.get(pos2);
            ig3 = I.get(pos3);
            ig4 = ig1.getScaledInstance(190, 122, 0);
            ig5 = ig2.getScaledInstance(190, 122, 0);
            ig6 = ig3.getScaledInstance(190, 122, 0);
            Icon1.setIcon(new ImageIcon(ig4));
            Icon2.setIcon(new ImageIcon(ig5));
            Icon3.setIcon(new ImageIcon(ig6));
            jButton3.setEnabled(true);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void ArchivesClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ArchivesClosed
        DefaultTableModel m = (DefaultTableModel) TableArchives.getModel();
        m.setRowCount(0);
        DefaultTreeModel m2 = new DefaultTreeModel(new DefaultMutableTreeNode("Sistema"));
        TreeArchives.setModel(m2);
        modifiedpath = "";
        modifiedpath = "";
    }//GEN-LAST:event_ArchivesClosed

    private void m_changebg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_changebg1ActionPerformed
        JFileChooser FChooser = new JFileChooser();
        FileFilter Filter = new FileNameExtensionFilter("Imágenes",
                "png", "jpg", "jpeg", "gif");
        FChooser.setFileFilter(Filter);
        File archive = null;
        int op = FChooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            archive = FChooser.getSelectedFile();
        }
        ImageIcon newBG = new ImageIcon(archive.getPath());
        BG.setIcon(newBG);
        JOptionPane.showMessageDialog(this, "¡Cambios aplicados exitósamente!");
    }//GEN-LAST:event_m_changebg1ActionPerformed

    private void PreviousSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousSongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreviousSongActionPerformed

    private void PlayPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayPauseMouseClicked
        if (play) {
            if (!Playlist.isSelectionEmpty()) {
                URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
                PlayPause.setIcon(new ImageIcon(source));
                MP.play();
                bm.setAvanzar(true);
                play = false;
            } else {
                JOptionPane.showMessageDialog(MusicPlayer, "No ha seleccionado ninguna canción.");
            }
        } else {
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/play-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            MP.pause();
            bm.setAvanzar(false);
            play = true;
        }
    }//GEN-LAST:event_PlayPauseMouseClicked

    private void ImportMusicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportMusicMouseClicked
        JFileChooser FChooser = new JFileChooser();
        DefaultListModel m = (DefaultListModel) Playlist.getModel();
        FileFilter Filter = new FileNameExtensionFilter("Archivos MP3",
                "mp3");
        FChooser.setFileFilter(Filter);
        try {
            int op = FChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {

                Files.copy(Paths.get(FChooser.getSelectedFile().getPath()),
                        Paths.get("./Sistema/"
                                + USER.getNombre()
                                + USER.getCMusica() + "/"
                                + FChooser.getSelectedFile().getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                MusicPaths.add("./Sistema/"
                        + USER.getNombre()
                        + USER.getCMusica() + "/"
                        + FChooser.getSelectedFile().getName());
                int i = MusicPaths.size();
                m.addElement(i + ".-  " + FChooser.getSelectedFile().getName() + "\n");
                Playlist.setModel(m);
                JOptionPane.showMessageDialog(MusicPlayer, "¡Archivo importado exitósamente!");
            }
        } catch (HeadlessException | IOException ex) {
            Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ImportMusicMouseClicked

    private void PlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaylistMouseClicked
        if (flagthread) {
            MusicPB.setValue(0);
            bm.setAvanzar(false);
            MP.stop();
            flagthread = false;
        }
        URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
        PlayPause.setIcon(new ImageIcon(source));

        PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
    }//GEN-LAST:event_PlaylistMouseClicked

    private void MusicPlayerWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MusicPlayerWindowClosing
        bm.stop();
        MP.stop();
    }//GEN-LAST:event_MusicPlayerWindowClosing

    private void NextSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextSongMouseClicked
        if (Playlist.getSelectedIndex() + 1 <= Playlist.getLastVisibleIndex()) {
            Playlist.setSelectedIndex(Playlist.getSelectedIndex() + 1);
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        } else {
            Playlist.setSelectedIndex(Playlist.getMaxSelectionIndex());
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        }
    }//GEN-LAST:event_NextSongMouseClicked

    private void PreviousSongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PreviousSongMouseClicked
        if (Playlist.getSelectedIndex() - 1 >= Playlist.getFirstVisibleIndex()) {
            Playlist.setSelectedIndex(Playlist.getSelectedIndex() - 1);
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        } else {
            Playlist.setSelectedIndex(Playlist.getMinSelectionIndex());
            Playlist.setSelectedIndex(Playlist.getSelectedIndex() - 1);
            if (flagthread) {
                MusicPB.setValue(0);
                bm.setAvanzar(false);
                MP.stop();
                flagthread = false;
            }
            URL source = Proyecto_AndreaMendoza.class.getResource("/Imagenes/pause-button.png");
            PlayPause.setIcon(new ImageIcon(source));
            PlaySong(new File(MusicPaths.get(Playlist.getSelectedIndex())));
        }
    }//GEN-LAST:event_PreviousSongMouseClicked

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        Paste.setEnabled(true);
        Cut.setEnabled(false);
        Copy.setEnabled(false);
        copyflag = true;
    }//GEN-LAST:event_CopyActionPerformed

    private void PasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteActionPerformed
        try {
            try {
                for (Object object : TreeArchives.getSelectionPath().getPath()) {
                    modifiedpath2 += object.toString() + "/";
                }
            } catch (Exception e) {
                System.out.println("error " + modifiedpath2);
            }
            modifiedpath2 = modifiedpath2.substring(0, modifiedpath2.lastIndexOf("/"));
            if (copyflag) {
                Files.copy(Paths.get(Modified.getPath()),
                        Paths.get(modifiedpath2 + "/" + Modified.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(Archives, "¡Documento copiado!");
            } else {
                Files.copy(Paths.get(Modified.getPath()),
                        Paths.get(modifiedpath2 + "/" + Modified.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                Files.delete(Paths.get(Modified.getPath()));
                JOptionPane.showMessageDialog(Archives, "¡Documento cortado!");
            }
        } catch (IOException ex) {
        }
        Cut.setEnabled(true);
        Copy.setEnabled(true);
        Archives.dispose();
        modifiedpath = "";
        modifiedpath2 = "";
        Paste.setEnabled(false);
    }//GEN-LAST:event_PasteActionPerformed

    private void CutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutActionPerformed
        Paste.setEnabled(true);
        Cut.setEnabled(false);
        Copy.setEnabled(false);
        copyflag = false;
    }//GEN-LAST:event_CutActionPerformed

    private void RenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenameActionPerformed
        String NewName = JOptionPane.showInputDialog("Ingrese el nuevo nombre del archivo.") + Modified.getName().substring(Modified.getName().lastIndexOf("."));
        Path source = Paths.get(Modified.getPath());
        File Temp = new File(source.toString());
        if (Temp.isDirectory()) {
            String OG = Temp.getName();
            if (OG.contains(USER.getCCalendario())) {
                USER.setCCalendario("/" + NewName);
            } else if (OG.contains(USER.getCCorreo())) {
                USER.setCCorreo("/" + NewName);
            } else if (OG.contains(USER.getCMusica())) {
                USER.setCMusica("/" + NewName);
            } else if (OG.contains(USER.getCImagenes())) {
                USER.setCImagenes("/" + NewName);
            } else if (OG.contains(USER.getCDocumentos())) {
                USER.setCDocumentos("/" + NewName);
            } else if (OG.contains(USER.getCMensaje())) {
                USER.setCMensaje("/" + NewName);
            }
        }
        try {
            Files.move(source, source.resolveSibling(NewName));
        } catch (IOException ex) {
        }
        JOptionPane.showMessageDialog(Archives, "¡Nombre cambiado exitósamente!");
        Archives.dispose();
    }//GEN-LAST:event_RenameActionPerformed

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked

    }//GEN-LAST:event_DeleteMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int resp = JOptionPane.showConfirmDialog(Archives, "¿En realidad desea eliminar el archivo?\nPodrá restaurar el documento desde la Papelera de Reciclaje siempre y cuando no apague el Sistema.");
        if (resp == JOptionPane.YES_OPTION) {
            try {
                String[] temp = new String[2];
                temp[0] = Modified.getPath();
                Files.copy(Paths.get(Modified.getPath()),
                        Paths.get("./Papelera de Reciclaje/" + Modified.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                Files.delete(Paths.get(Modified.getPath()));
                temp[1] = "./Papelera de Reciclaje/" + Modified.getName();
                Recycle.add(temp);
                JOptionPane.showMessageDialog(Archives, "¡Documento eliminado exitósamente!");
            } catch (IOException ex) {
                Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String tipo;
        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();

        try {
            BasicFileAttributes attr = Files.readAttributes(Paths.get("./Papelera de Reciclaje/" + Modified.getName()), BasicFileAttributes.class);
            if (Modified.getName().contains(".")) {
                tipo = "Archivo " + Modified.getName().substring(Modified.getName().lastIndexOf("."));
            } else {
                tipo = "Carpeta de Archivos";
            }
            Object[] Directories = {Modified.getName(), attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
            m.addRow(Directories);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar localizar el archivo.");
        }
        RecycleBinTable.setModel(m);
    }//GEN-LAST:event_DeleteActionPerformed

    private void RecycleBinTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecycleBinTableMouseClicked
        DefaultTableModel m = (DefaultTableModel) TableArchives.getModel();
        if (RecycleBinTable.getSelectedRow() > -1) {
            if (evt.isMetaDown()) {
                RBPM.show(RecycleBinTable, evt.getX(), evt.getY());
            }
        }

    }//GEN-LAST:event_RecycleBinTableMouseClicked

    private void jScrollPane7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane7MouseClicked

    private void DeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePActionPerformed
        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();
        try {
            Files.delete(Paths.get("./Papelera de Reciclaje/" + m.getValueAt(RecycleBinTable.getSelectedRow(), 0).toString()));
        } catch (IOException ex) {
        }
        JOptionPane.showMessageDialog(RecycleBin, "Archivo eliminado permanentemente.");
    }//GEN-LAST:event_DeletePActionPerformed

    private void RestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestoreActionPerformed
        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();
        for (String[] s : Recycle) {
            for (String string : s) {
                if (string.contains(m.getValueAt(RecycleBinTable.getSelectedRow(), 0).toString())) {
                    if (USER instanceof Administrador) {
                        try {
                            Files.copy(Paths.get(Recycle.get(Recycle.indexOf(s))[1]), Paths.get(Recycle.get(Recycle.indexOf(s))[0]),
                                    StandardCopyOption.REPLACE_EXISTING);
                            Files.delete(Paths.get(Recycle.get(Recycle.indexOf(s))[1]));
                        } catch (IOException ex) {
                            Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(RecycleBin, "¡Archivo restaurado exitósamente!");
                        break;
                    } else if (string.contains(USER.getNombre())) {
                        try {
                            Files.copy(Paths.get(Recycle.get(Recycle.indexOf(s))[1]), Paths.get(Recycle.get(Recycle.indexOf(s))[0]),
                                    StandardCopyOption.REPLACE_EXISTING);
                            Files.delete(Paths.get(Recycle.get(RecycleBinTable.getSelectedRow())[1]));
                        } catch (IOException ex) {
                            Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(RecycleBin, "¡Archivo restaurado exitósamente!");
                    } else {
                        JOptionPane.showMessageDialog(RecycleBin, "No tiene permitido restaurar archivos que no hayan sido suyos.");
                    }
                }
            }
        }
    }//GEN-LAST:event_RestoreActionPerformed

    private void ConsoleTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConsoleTextKeyPressed
        boolean a = false;
        Scanner c = new Scanner(ConsoleText.getText());
        String command = "";
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            while (c.hasNext()) {
                command = c.nextLine();
            }
            Scanner c2 = new Scanner(command);
            c2.useDelimiter(">");
            while (c2.hasNext()) {
                command = c2.next();
            }
            System.out.println(command);
            for (String cw : CodeWords) {
                if (command.contains(cw) || a == true) {
                    if (command.matches("mkdir<.*")) {
                        String[] temp = command.split("<");
                        String name = temp[1].substring(0, temp[1].length());
                        File nf = new File("./Sistema/" + USER.getNombre() + "/" + name);
                        nf.mkdir();
                        PathsNodes.add(nf.getPath());
                        ConsoleText.append("\n Directorio " + name + " creado.");
                        break;
                    } else if (command.matches("rm<.*")) {
                        String[] temp = command.split("<");
                        String name = temp[1].substring(0, temp[1].length());
                        for (String p : PathsNodes) {
                            if ((!(p.contains(name + "/")) && (p.contains(name)))) {
                                if ((USER instanceof Administrador) || (p.contains(USER.getNombre()))) {
                                    try {
                                        String[] temp2 = new String[2];
                                        temp2[0] = p;
                                        Files.copy(Paths.get(p),
                                                Paths.get("./Papelera de Reciclaje/" + name),
                                                StandardCopyOption.REPLACE_EXISTING);
                                        Files.delete(Paths.get(p));
                                        temp2[1] = "./Papelera de Reciclaje/" + name;
                                        Recycle.add(temp2);
                                        ConsoleText.append("\n Archivo " + name + " eliminado.");
                                        String tipo;
                                        DefaultTableModel m = (DefaultTableModel) RecycleBinTable.getModel();

                                        try {
                                            BasicFileAttributes attr = Files.readAttributes(Paths.get("./Papelera de Reciclaje/" + name), BasicFileAttributes.class);
                                            if (name.contains(".")) {
                                                tipo = "Archivo " + name.substring(name.lastIndexOf("."));
                                            } else {
                                                tipo = "Carpeta de Archivos";
                                            }
                                            Object[] Directories = {name, attr.lastModifiedTime(), tipo, String.valueOf(attr.size() / 1000) + " KB"};
                                            m.addRow(Directories);
                                        } catch (IOException ex) {
                                            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al intentar localizar el archivo.");
                                        }
                                        RecycleBinTable.setModel(m);
                                        break;
                                    } catch (IOException ex) {
                                        Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    ConsoleText.append("\nNo tiene acceso a este archivo.");
                                    break;
                                }
                            } else if (PathsNodes.indexOf(p) == PathsNodes.size() - 1) {
                                ConsoleText.append("\nNo se puede localizar el archivo.");
                                break;
                            }
                        }
                        break;
                    } else if (command.matches("cd<.*")) {
                        System.out.println("entra cd");
                        String[] temp = command.split("<");
                        String name = temp[1].substring(0, temp[1].length());
                        for (String p : PathsNodes) {
                            if ((!(p.contains(name + "/")) && (p.contains(name)))) {
                                if ((USER instanceof Administrador) || (p.contains(USER.getNombre()))) {
                                    currentpath = p;
                                    pathaesthetic = "\nSistema:\\" + p.substring(9) + ">";
                                    break;
                                } else if (PathsNodes.indexOf(p) == PathsNodes.size() - 1 && (!(p.contains(USER.getNombre())))) {
                                    ConsoleText.append("\nNo se puede localizar el archivo o no tiene acceso a él.");
                                    break;
                                }
                            }
                        }
                        break;
                    } else if (command.equalsIgnoreCase("cd..")) { // Corregir
                        File f = new File(currentpath);
                        if (f.getParent().contains("Sistema")) {
                            System.out.println(currentpath);
                            currentpath = currentpath.substring(0, currentpath.lastIndexOf("\\"));
                            System.out.println("antes " + currentpath);
                            int pos = 10;
                            if (currentpath.equalsIgnoreCase(".\\Sistema")) {
                                pos = 9;
                            }
                            pathaesthetic = "\nSistema:\\\\" + currentpath.substring(pos) + ">";
                        } else {
                            ConsoleText.append("\nHa llegado al archivo raíz.");
                            currentpath = "./Sistema";
                            pathaesthetic = "\nSistema:\\\\>";
                        }
                        break;
                    } else if (command.equalsIgnoreCase("time")) {
                        Date h = new Date();
                        DateFormat f = new SimpleDateFormat("hh:mm:ss a");
                        ConsoleText.append("\n La hora actual es: " + f.format(h));
                        break;
                    } else if (command.equalsIgnoreCase("date")) {
                        Date h = new Date();
                        DateFormat f = new SimpleDateFormat("EEEEE, MMMMM dd yyyy");
                        ConsoleText.append("\n La fecha actual es: " + f.format(h) + ".");
                        break;
                    } else if (command.equalsIgnoreCase("dir")) {
                        ConsoleText.append("\n\nDirectorio de " + pathaesthetic + "\n\n");
                        File D = new File(currentpath);
                        File[] Tabla = D.listFiles();
                        String tipo = "";
                        int contarchs = 0, bytearchs = 0, contdirs = 0, bytedirs = 0;
                        try {
                            for (File file : Tabla) {
                                BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
                                String size = String.format("%04d", attr.size());
                                if (attr.isDirectory()) {
                                    tipo = "<DIR>";
                                    ++contdirs;
                                    bytedirs += attr.size();
                                } else {
                                    ++contarchs;
                                    bytearchs += attr.size();
                                }
                                DateFormat date = new SimpleDateFormat("dd/mm/yyyy");
                                DateFormat time = new SimpleDateFormat("HH:mm");
                                ConsoleText.append(date.format(new Date(attr.creationTime().toMillis())) + "  " + time.format(new Date(attr.creationTime().toMillis())) + "  " + tipo + "  " + size + "  " + file.getName() + "\n");

                            }
                        } catch (IOException ex) {
                        }
                        ConsoleText.append("          " + contarchs + " archivos          " + bytearchs + " bytes\n          " + contdirs + " dirs          " + bytedirs + " bytes\n");
                        break;
                    } else if (command.equalsIgnoreCase("help")) {
                        ConsoleText.append("\n Instrucciones Válidas:\n"
                                + "  a. Mkdir <nombre>: Nueva carpeta.\n"
                                + "  b. Rm <nombre>: Eliminar carpeta.\n"
                                + "  c. Cd <nombre carpeta>: Cambiar de carpeta actual.\n"
                                + "  d. Cd.. Regresar de Carpeta.\n"
                                + "  e. Dir: Listar todas las carpetas y archivos en la carpeta actual.\n"
                                + "  f. Date: Ver fecha actual.\n"
                                + "  g. Time: Ver hora actual.\n");
                        break;
                    }
                } else if (CodeWords.indexOf(cw) == CodeWords.size() - 1) {
                    ConsoleText.append("\n INTRUCCIÓN INVÁLIDA. Escriba HELP para ver los comandos permitidos.\n\n");
                }
            }
            ConsoleText.append(pathaesthetic);
        }

    }//GEN-LAST:event_ConsoleTextKeyPressed

    private void StopButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopButtonMouseClicked
        MP.stop();
        bm.setAvanzar(false);
        MusicPB.setValue(0);
    }//GEN-LAST:event_StopButtonMouseClicked

    private void txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMouseClicked
        if (evt.isMetaDown()) {
            TextPM.show(TextEditor, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_txtMouseClicked

    private void SendMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendMMouseClicked
        boolean emptym = true;
        boolean emptyc = true;
        DefaultListModel m = (DefaultListModel) Contacts.getModel();
        if (Contacts.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(Messenger, "Por favor, selecciona un receptor del mensaje antes de continuar.");
            emptym = false;
        }
        if (Message.getText().equals("")) {
            JOptionPane.showMessageDialog(Messenger, "No puede enviar un mensaje en blanco.");
            emptyc = false;
        }
        if (emptym == true && emptyc == true) {
            U2 = (Usuario) m.getElementAt(Contacts.getSelectedIndex());
            String message = USER.getNombre() + ": " + Message.getText();
            Convo.append(message);
            Message.setText("");
            File convo = new File("./Sistema/" + USER.getNombre() + "/" + USER.getCMensaje() + "/Conversación con " + U2.getNombre() + ".txt");
            File convo2 = new File("./Sistema/" + U2.getNombre() + "/" + U2.getCMensaje() + "/Conversación con " + USER.getNombre() + ".txt");
            NormalDocsAdmin nd = new NormalDocsAdmin(convo, Message);
            NormalDocsAdmin nd2 = new NormalDocsAdmin(convo2, Message);
            nd.writeMessages();
            nd2.writeMessages();
            U2.setMsn(true);
        }
    }//GEN-LAST:event_SendMMouseClicked

    private void EditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditTextActionPerformed
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();

        String[] allFonts = ge.getAvailableFontFamilyNames();
        DefaultListModel m = (DefaultListModel) fonts.getModel();
        for (String font : allFonts) {
            m.addElement(font);
        }
        FontChooser.pack();
        FontChooser.setLocationRelativeTo(null);
        FontChooser.setVisible(true);
    }//GEN-LAST:event_EditTextActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        FontChooser.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void OkayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OkayMouseClicked
        StyledDocument doc = txt.getStyledDocument();
        Style estilo = txt.addStyle("miEstilo", null);
        StyleConstants.setForeground(estilo, muestra.getBackground());
        StyleConstants.setFontFamily(estilo, fonts.getSelectedValue());
        if (style.getSelectedValue().equals("Underline")) {
            StyleConstants.setUnderline(estilo, true);
        }
        if (style.getSelectedValue().equals("Bold") || style.getSelectedValue().equals("Bold Italic")) {
            StyleConstants.setBold(estilo, true);
        }
        if (style.getSelectedValue().equals("Italic") || style.getSelectedValue().equals("Bold Italic")) {
            StyleConstants.setItalic(estilo, true);
        }
        StyleConstants.setFontSize(estilo, Integer.parseInt(size.getSelectedValue()));
        doc.setCharacterAttributes(txt.getSelectionStart(),
                txt.getSelectionEnd() - txt.getSelectionStart(),
                txt.getStyle("miEstilo"),
                true);
        FontChooser.setVisible(false);
    }//GEN-LAST:event_OkayMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        Color c = JColorChooser.showDialog(TextEditor, "Seleccione un color.", Color.yellow);
        muestra.setBackground(c);
    }//GEN-LAST:event_jButton5MouseClicked

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        try {
            JFileChooser FChooser = new JFileChooser("./Sistema/" + USER.getNombre() + "/" + USER.getCDocumentos());
            FileFilter Filter = new FileNameExtensionFilter("Documentos de Texto",
                    "txt");
            FChooser.setFileFilter(Filter);
            File archive = null;
            int op = FChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archive = FChooser.getSelectedFile();
            }

            TextDocAdmin TA = new TextDocAdmin(archive, txt);
            TA.loadArchive();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDocActionPerformed
        try {
            String name = JOptionPane.showInputDialog(TextEditor, "Ingrese un nombre para el documento.");
            File archive = new File("./Sistema/" + USER.getNombre() + "/" + USER.getCDocumentos() + "/" + name + ".txt");
            TextDocAdmin TA = new TextDocAdmin(archive, txt);
            TA.writeArchive();
        } catch (IOException ex) {
        } catch (BadLocationException ex) {
        }
        JOptionPane.showMessageDialog(TextEditor, "¡Documento guardado exitósamente!");
    }//GEN-LAST:event_SaveDocActionPerformed

    private void ContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContactsMouseClicked
        try {
            DefaultListModel m = (DefaultListModel) Contacts.getModel();
            U2 = (Usuario) m.getElementAt(Contacts.getSelectedIndex());
            File convo = new File("./Sistema/" + USER.getNombre() + "/" + USER.getCMensaje() + "/Conversación con " + U2.getNombre() + ".txt");
            NormalDocsAdmin nd = new NormalDocsAdmin(convo, Convo);
            nd.readMessages();
            Message.setText("");
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_ContactsMouseClicked

    private void TypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TypeItemStateChanged
        ++cbflag;
        if (cbflag == 2) {
            if (Type.getSelectedItem().toString().equals("Evento")) {
                start.setEnabled(true);
                end.setEnabled(true);
                Content.setEnabled(false);
                Notes.setEnabled(false);
            } else {
                Content.setEnabled(true);
                Notes.setEnabled(true);
                start.setEnabled(false);
                end.setEnabled(false);
            }
            cbflag = 0;
        }
    }//GEN-LAST:event_TypeItemStateChanged

    private void savedateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savedateMouseClicked
        try {
            boolean rec = false;
            int resp = JOptionPane.showConfirmDialog(Agenda, "¿Desea guardar un recordatorio para la actividad?");
            int mins = 0;
            if (resp == JOptionPane.YES_OPTION) {
                rec = true;
                try {
                    mins = Integer.parseInt(JOptionPane.showInputDialog(Agenda, "Ingrese cuántos minutos antes\nde la actividad desea enviar una alarma."));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(agenda, "Ingrese un número válido.");
                }
            }
            if (Type.getSelectedItem().toString().equals("Evento")) {
                USER.addAs(new Eventos((Date) start.getValue(), (Date) end.getValue(), Fecha.getDate(), Title.getText(), rec, mins));
            } else if (Type.getSelectedIndex() != 0) {
                USER.addAs(new Tareas(Content.getText(), TempFiles, Fecha.getDate(), Title.getText(), rec, mins));
            }
            Files.createDirectory(Paths.get(new File(".\\Sistema\\" + USER.getNombre() + "\\" + USER.getCCalendario() + "\\" + Title.getText()).getPath()));
            for (File tf : TempFiles) {
                try {
                    Files.copy(Paths.get(tf.getPath()),
                            Paths.get(new File(".\\Sistema\\" + USER.getNombre() + "\\" + USER.getCCalendario() + "\\" + Title.getText()).getPath() + "\\" + tf.getName()),
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                }
            }
            JOptionPane.showMessageDialog(Agenda, "¡Actividad guardada exitósamente.");
            Title.setText("");
            rec = false;
            mins = 0;
            Content.setText("");
            TempFiles = new ArrayList();
            Content.setEnabled(false);
            Notes.setEnabled(false);
            Notes.setText("Seleccionar Notas");
            start.setEnabled(false);
            end.setEnabled(false);
            Type.setSelectedIndex(0);
        } catch (IOException ex) {
            Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_savedateMouseClicked

    private void calMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calMouseClicked

    }//GEN-LAST:event_calMouseClicked

    private void calPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calPropertyChange
        DefaultTableModel m = (DefaultTableModel) agenda.getModel();
        for (Actividades a : USER.getAs()) {
            if ((a.getDate().getDate() == cal.getDate().getDate()) && (a.getDate().getMonth() == cal.getDate().getMonth())) {
            } else {
                Object[] temp = {a.getClass().getName(), a.getTitle(), a.isReminder()};
                m.addRow(temp);
            }
        }
        agenda.setModel(m);
    }//GEN-LAST:event_calPropertyChange

    private void FechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_FechaPropertyChange
        //   SpinnerModel m = (SpinnerDateModel) start.getModel();
        //    m.setValue(Fecha.getDate());
    }//GEN-LAST:event_FechaPropertyChange

    private void NotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotesMouseClicked
        JFileChooser FChooser = new JFileChooser();
        FileFilter Filter = new FileNameExtensionFilter("Notas",
                "doc", "docx", "txt");
        FChooser.setFileFilter(Filter);
        File archive = null;
        int op = FChooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            archive = FChooser.getSelectedFile();
        }
        TempFiles.add(archive);
        JOptionPane.showMessageDialog(agenda, "¡Nota importada exitósamente!");
        Notes.setText("Agregar otra nota.");
    }//GEN-LAST:event_NotesMouseClicked

    private void ShareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShareActionPerformed

    private void UsersBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersBMouseClicked
        this.AllUsersPV.pack();
        AllUsersPV.setLocationRelativeTo(null);
        AllUsersPV.setVisible(true);
    }//GEN-LAST:event_UsersBMouseClicked

    private void NotifsBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotifsBMouseClicked
        DefaultTableModel m = (DefaultTableModel) notifs.getModel();
        m.setRowCount(0);
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        try {
            db.query.execute("select Emisor from Solicitudes where Receptor='" + USER.getUsername() + "'");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                Object[] temp = {rs.next(), "Solicitud de Amistad"};
                m.addRow(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        notifs.setModel(m);
        db.desconectar();
        this.Notifications.pack();
        Notifications.setLocationRelativeTo(null);
        Notifications.setVisible(true);
    }//GEN-LAST:event_NotifsBMouseClicked

    private void PerfilBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PerfilBMouseClicked
        UserName1.setText(USER.getNombre());
        int contA = 0;
        int contP = 0;
        UserPic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png")));
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        try {
            db.query.execute("select A1 from Amigos where A1='" + USER.getUsername() + "'");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                ++contA;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            db.query.execute("select Autor,Titulo,Fecha,Likes from Publicaciones where Autor='" + USER.getUsername() + "'");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                ++contP;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultTableModel m = (DefaultTableModel) mywall.getModel();
        m.setRowCount(0);
        RefreshMyWall();
        db.desconectar();
        ContAmigos1.setText(String.valueOf(contA));
        ContP1.setText(String.valueOf(contP));

        MyProfile.pack();
        MyProfile.setLocationRelativeTo(null);
        MyProfile.setVisible(true);
    }//GEN-LAST:event_PerfilBMouseClicked

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        Status.pack();
        Status.setLocationRelativeTo(null);
        Status.setVisible(true);
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        Picture.pack();
        Picture.setLocationRelativeTo(null);
        Picture.setVisible(true);
    }//GEN-LAST:event_jButton23MouseClicked

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        Album.pack();
        Album.setLocationRelativeTo(null);
        Album.setVisible(true);
    }//GEN-LAST:event_jButton24MouseClicked

    private void ShareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShareMouseClicked
        Posts P = new Posts(USER.getUsername(), NewStatus.getText(), 0, new Date());
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        DateFormat f = new SimpleDateFormat("dd/mm/yy hh:mm:ss");
        try {
            db.query.execute("INSERT INTO Publicaciones"
                    + " (Autor, Titulo, Likes, Tipo, Fecha)"
                    + " VALUES ('" + P.getAuthor() + "', '" + P.getTitulo() + "', 0, '" + P.getTipo() + "', '" + f.format(P.getCreate()) + "')");
            db.commit();
            JOptionPane.showMessageDialog(Status, "¡Estado compartido exitósamente!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();

    }//GEN-LAST:event_ShareMouseClicked

    private void SharePicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SharePicMouseClicked
        Posts P = new Posts(USER.getUsername(), DescPic.getText(), imagepath, 0, new Date());
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        DateFormat f = new SimpleDateFormat("dd/mm/yy hh:mm:ss");
        try {
            db.query.execute("INSERT INTO Publicaciones"
                    + " (Autor, Titulo, Likes, PathFoto, Tipo, Fecha)"
                    + " VALUES ('" + P.getAuthor() + "', '" + P.getDesc() + "', 0, '" + imagepath + "', '" + P.getTipo() + "', '" + f.format(P.getCreate()) + "')");
            db.commit();
        } catch (SQLException ex) {
        }
        db.desconectar();
        JOptionPane.showMessageDialog(Status, "¡Foto compartida exitósamente!");
    }//GEN-LAST:event_SharePicMouseClicked

    private void selectpicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectpicMouseClicked
        JFileChooser FChooser = new JFileChooser();
        FileFilter Filter = new FileNameExtensionFilter("Imágenes",
                "png", "jpg", "jpeg", "gif");
        FChooser.setFileFilter(Filter);
        File archive = null;
        int op = FChooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            archive = FChooser.getSelectedFile();
        }
        ImageIcon imageIcon = new ImageIcon(archive.getPath());
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 165, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        PreviewPic.setIcon(imageIcon);
    }//GEN-LAST:event_selectpicMouseClicked

    private void AddPicsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPicsMouseClicked
        DefaultListModel m = (DefaultListModel) AlbumList.getModel();
        if (m.size() <= 4) {
            JFileChooser FChooser = new JFileChooser();
            FileFilter Filter = new FileNameExtensionFilter("Imágenes",
                    "png", "jpg", "jpeg", "gif");
            FChooser.setFileFilter(Filter);
            File archive = null;
            int op = FChooser.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archive = FChooser.getSelectedFile();
                albumpaths.add(archive.getPath());
                m.addElement(archive.getName());
                AlbumList.setModel(m);
                JOptionPane.showMessageDialog(Album, "¡Imagen agregada exitósamente!");
            }
        } else {
            JOptionPane.showMessageDialog(Album, "El máximo de fotos que puede subir es de 4 imágenes por álbum.");
        }

    }//GEN-LAST:event_AddPicsMouseClicked

    private void jButton25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseClicked

    }//GEN-LAST:event_jButton25MouseClicked

    private void FilterUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FilterUsuariosItemStateChanged
        DefaultListModel m = (DefaultListModel) UsuariosLista.getModel();
        m.removeAllElements();
        if (cbflag == 2) {
            Dba db = new Dba("./TheSN.accdb");
            db.conectar();
            if (FilterUsuarios.getSelectedIndex() == 1) {
                try {
                    db.query.execute("select A2 from Amigos where A1='" + USER.getUsername() + "'");
                    ResultSet rs = db.query.getResultSet();
                    while (rs.next()) {
                        m.addElement(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else if (FilterUsuarios.getSelectedIndex() == 2) {
                try {
                    db.query.execute("select Nombre from Usuarios where Nombre not in (select A2 from Amigos where A1='" + USER.getUsername() + "')");
                    ResultSet rs = db.query.getResultSet();
                    while (rs.next()) {
                        m.addElement(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            db.desconectar();
        }
        UsuariosLista.setModel(m);
    }//GEN-LAST:event_FilterUsuariosItemStateChanged

    private void UsuariosListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuariosListaMouseClicked
        int contA = 0;
        int contP = 0;
        for (Usuario User : Users) {
            if (User.getNombre().equals(UsuariosLista.getSelectedValue())) {
                U2 = User;
                break;
            }
        }
        UserName.setText(U2.getUsername());
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        try {
            db.query.execute("select A1 from Amigos where A1='" + U2.getUsername() + "'");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                ++contA;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            db.query.execute("select Autor from Publicaciones where Autor='" + U2.getUsername() + "'");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                ++contP;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
        ContAmigos.setText(String.valueOf(contA));
        ContP.setText(String.valueOf(contP));
    }//GEN-LAST:event_UsuariosListaMouseClicked

    private void AddBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBMouseClicked
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        try {
            db.query.execute("INSERT INTO Solicitudes"
                    + " (Emisor,Receptor)" // String van en ´´
                    + " VALUES ('" + USER.getNombre() + "', '" + U2.getUsername() + "')");
            db.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
        JOptionPane.showMessageDialog(PerfilPreview, "¡Solicitud de Amistad enviada!");
    }//GEN-LAST:event_AddBMouseClicked

    private void notifsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notifsMouseClicked
        String User2 = (String) notifs.getValueAt(notifs.getSelectedRow(), 0);
        DefaultTableModel m = (DefaultTableModel) notifs.getModel();
        int resp = JOptionPane.showConfirmDialog(Notifications, "¿Desea agregar a " + User2 + " como su amigo/a?");
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        if (resp == JOptionPane.YES_OPTION) {
            try {
                db.query.execute("INSERT INTO Amigos"
                        + " (A1, A2)"
                        + " VALUES ('" + User2 + "', '" + USER.getUsername() + "')");
                db.query.execute("INSERT INTO Amigos"
                        + " (A1, A2)" // String vaselect Nombre from n en ´´
                        + " VALUES ('" + USER.getUsername() + "', '" + User2 + "')");
                db.commit();
                db.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(PP.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(Notifications, "¡Ahora tu y " + User2 + " son amigos!");
        } else {
            JOptionPane.showMessageDialog(Notifications, "Solicitud de Amistad rechazada.");
        }
        try {
            db.query.execute("delete from Solicitudes where Emisor='" + User2 + "' AND Receptor='" + USER.getUsername() + "'");
            db.commit();
            m.removeRow(notifs.getSelectedRow());
            notifs.setModel(m);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_notifsMouseClicked

    private void ChangePPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePPMouseClicked
        JFileChooser FChooser = new JFileChooser();
        FileFilter Filter = new FileNameExtensionFilter("Imágenes",
                "png", "jpg", "jpeg", "gif");
        FChooser.setFileFilter(Filter);
        File archive = null;
        int op = FChooser.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            archive = FChooser.getSelectedFile();
        }
        ImageIcon imageIcon = new ImageIcon(archive.getPath());
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(-1, 145, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        UserPic1.setIcon(imageIcon);
        JOptionPane.showMessageDialog(this, "¡Cambios aplicados exitósamente!");
    }//GEN-LAST:event_ChangePPMouseClicked

    private void mywallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mywallMouseClicked
        if (evt.isMetaDown()) {
            source = evt.getSource();
            PMPosts.show((Component) source, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_mywallMouseClicked

    private void WallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WallMouseClicked
        if (evt.isMetaDown()) {
            source = evt.getSource();
            PMPosts.show((Component) source, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_WallMouseClicked

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewActionPerformed
        MyProfile.setVisible(false);
        FullPost((JTable) source);
    }//GEN-LAST:event_ViewActionPerformed

    private void pic1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pic1MouseClicked
        Image image = ((ImageIcon) pic1.getIcon()).getImage();
        Image newimg = image.getScaledInstance(-1, 468, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        mainpicv.setIcon(imageIcon);
        IndPic.pack();
        IndPic.setLocationRelativeTo(null);
        IndPic.setVisible(true);
    }//GEN-LAST:event_pic1MouseClicked

    private void pic2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pic2MouseClicked
        Image image = ((ImageIcon) pic2.getIcon()).getImage();
        Image newimg = image.getScaledInstance(-1, 468, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        mainpicv.setIcon(imageIcon);
        IndPic.pack();
        IndPic.setLocationRelativeTo(null);
        IndPic.setVisible(true);
    }//GEN-LAST:event_pic2MouseClicked

    private void pic3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pic3MouseClicked
        Image image = ((ImageIcon) pic3.getIcon()).getImage();
        Image newimg = image.getScaledInstance(-1, 468, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        mainpicv.setIcon(imageIcon);
        IndPic.pack();
        IndPic.setLocationRelativeTo(null);
        IndPic.setVisible(true);
    }//GEN-LAST:event_pic3MouseClicked

    private void pic4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pic4MouseClicked
        Image image = ((ImageIcon) pic4.getIcon()).getImage();
        Image newimg = image.getScaledInstance(-1, 468, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        mainpicv.setIcon(imageIcon);
        IndPic.pack();
        IndPic.setLocationRelativeTo(null);
        IndPic.setVisible(true);
    }//GEN-LAST:event_pic4MouseClicked

    private void AddPics1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPics1MouseClicked
        Comment(albmt.getText());
    }//GEN-LAST:event_AddPics1MouseClicked

    private void ShareAlbum1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShareAlbum1MouseClicked
        Like(albmt.getText());
    }//GEN-LAST:event_ShareAlbum1MouseClicked

    private void commentpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentpMouseClicked
        Comment(DescPic1.getText());
    }//GEN-LAST:event_commentpMouseClicked

    private void likepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_likepMouseClicked
        Like(DescPic1.getText());
    }//GEN-LAST:event_likepMouseClicked

    private void LikePostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LikePostMouseClicked
        Like(NewStatus1.getText());
        DefaultTableModel m = (DefaultTableModel) Wall.getModel();
        DefaultTableModel m2 = (DefaultTableModel) mywall.getModel();
        m.setRowCount(0);
    }//GEN-LAST:event_LikePostMouseClicked

    private void CommentPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CommentPostMouseClicked
        Comment(NewStatus1.getText());
    }//GEN-LAST:event_CommentPostMouseClicked

    private void NewStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewStatusMouseClicked
        NewStatus.setText("");
    }//GEN-LAST:event_NewStatusMouseClicked

    private void DescPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DescPicMouseClicked
        DescPic.setText("");
    }//GEN-LAST:event_DescPicMouseClicked

    private void ShareAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShareAlbumMouseClicked
        Posts P = new Posts(USER.getUsername(), AlbumTitle.getText(), DescAlbum.getText(), albumpaths, 0, new Date());
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        DefaultListModel m = (DefaultListModel) AlbumList.getModel();
        switch (m.size()) {
            case 1:
                try {
                    db.query.execute("INSERT INTO Publicaciones"
                            + " (Autor, Titulo, Likes, PathFoto, Tipo, Fecha)"
                            + " VALUES ('" + P.getAuthor() + "', '" + P.getDesc() + "', 0, '" + P.getPathFoto1() + "', '" + P.getTipo() + "', '" + P.getCreate() + "')");
                    db.commit();
                } catch (SQLException ex) {
                }
                db.desconectar();
                break;
            case 2:
                try {
                    db.query.execute("INSERT INTO Publicaciones"
                            + " (Autor, Titulo, Likes, PathFoto, PathFoto2, Tipo, Fecha)"
                            + " VALUES ('" + P.getAuthor() + "', '" + P.getDesc() + "', 0, '" + P.getPathFoto1() + "', '" + P.getPathFoto2() + "', '" + P.getTipo() + "', '" + P.getCreate() + "')");
                    db.commit();
                } catch (SQLException ex) {
                }
                db.desconectar();
                break;
            case 3:
                try {
                    db.query.execute("INSERT INTO Publicaciones"
                            + " (Autor, Titulo, Likes, PathFoto, PathFoto2, PathFoto3, Tipo, Fecha)"
                            + " VALUES ('" + P.getAuthor() + "', '" + P.getDesc() + "', 0, '" + P.getPathFoto1() + "', '" + P.getPathFoto2() + "', '" + P.getPathFoto3() + "', '" + P.getTipo() + "', '" + P.getCreate() + "')");
                    db.commit();
                } catch (SQLException ex) {
                }
                break;
            case 4:
                try {
                    db.query.execute("INSERT INTO Publicaciones"
                            + " (Autor, Titulo, Likes, PathFoto, PathFoto2, PathFoto3, PathFoto4 tipo)"
                            + " VALUES ('" + P.getAuthor() + "', '" + P.getDesc() + "', 0, '" + P.getPathFoto1() + "', '" + P.getPathFoto2() + "', '" + P.getPathFoto3() + "', '" + P.getPathFoto4() + "', '" + P.getTipo() + "')");
                    db.commit();
                } catch (SQLException ex) {
                }
                break;
        }
        db.desconectar();
        JOptionPane.showMessageDialog(Status, "¡Imagen agregada exitósamente!");
    }//GEN-LAST:event_ShareAlbumMouseClicked

    public void FullPost(JTable table) {
        String name = (String) table.getValueAt(table.getSelectedRow(), 2);
        String author = (String) table.getValueAt(table.getSelectedRow(), 1);
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        try {
            db.query.execute("select Tipo,Autor,Titulo,PathFoto,PathFoto2,PathFoto3,PathFoto4,Desc from Publicaciones where Autor='" + author + "' AND Titulo='" + name + "'"); // %% no importa que haya antes o despues
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                switch (rs.getString(1)) {
                    case "txt":
                        namepost.setText(rs.getString(2));
                        NewStatus1.setText(rs.getString(3));
                        ViewStatus.pack();
                        ViewStatus.setLocationRelativeTo(null);
                        ViewStatus.setVisible(true);
                        break;
                    case "albm":
                        if (rs.getString(4) != null) {
                            Image img = Toolkit.getDefaultToolkit().createImage(
                                    rs.getString(4));
                            ImageIcon imageIcon = new ImageIcon(img);
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(-1, 130, java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);
                            pic1.setIcon(imageIcon);
                            pic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png")));
                            pic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png")));
                            pic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png")));
                        }
                        if (rs.getString(5) != null) {
                            Image img = Toolkit.getDefaultToolkit().createImage(
                                    rs.getString(5));
                            ImageIcon imageIcon = new ImageIcon(img);
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(-1, 130, java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);
                            pic2.setIcon(imageIcon);
                            pic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png")));
                            pic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png")));
                        }
                        if (rs.getString(6) != null) {
                            Image img = Toolkit.getDefaultToolkit().createImage(
                                    rs.getString(6));
                            ImageIcon imageIcon = new ImageIcon(img);
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(-1, 130, java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);
                            pic3.setIcon(imageIcon);
                            pic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noimage.png")));
                        }
                        if (rs.getString(7) != null) {
                            Image img = Toolkit.getDefaultToolkit().createImage(
                                    rs.getString(7));
                            ImageIcon imageIcon = new ImageIcon(img);
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(-1, 130, java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);
                            pic4.setIcon(imageIcon);
                        }
                        albmt.setText(rs.getString(3));
                        albmdesc.setText(rs.getString(8));
                        ViewAlbum.pack();
                        ViewAlbum.setLocationRelativeTo(null);
                        ViewAlbum.setVisible(true);
                        break;
                    case "img":
                        Image img = Toolkit.getDefaultToolkit().createImage(
                                rs.getString(4));
                        ImageIcon imageIcon = new ImageIcon(img);
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(-1, 221, java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);
                        PreviewPic1.setIcon(imageIcon);
                        DescPic1.setText(rs.getString(3));
                        ViewPicture.pack();
                        ViewPicture.setLocationRelativeTo(null);
                        ViewPicture.setVisible(true);
                        break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }

    public void Comment(String title) {
        String comment = JOptionPane.showInputDialog("Escribe tu comentario.");
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        try {
            db.query.execute("INSERT INTO Comentarios"
                    + " (Comentario,Titulo)" // String van en ´´
                    + " VALUES ('" + comment + "', '" + title + "')");
            db.commit();
            JOptionPane.showMessageDialog(null, "¡Comentario enviado!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }

    public void Like(String title) {
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        try {
            db.query.execute("select Likes from Publicaciones where Titulo='" + title + "'"); // %% no importa que haya antes o despues
            db.query.execute("update Publicaciones set Likes=Likes+1 where Titulo='" + title + "'");
            db.commit();
            JOptionPane.showMessageDialog(null, "¡Te gusta esta publicación!");
            RefreshMyWall();
            //  contlike = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.desconectar();
    }

    public void PlaySong(File song) {
        p = new Media(song.toURI().toString());
        MusicPB.setValue(0);
        MP = new MediaPlayer(p);
        MP.play();

        try {
            try {
                MP.setOnReady(new Runnable() {
                    @Override
                    public void run() {
                        double time = p.getDuration().toSeconds();
                        int min = (int) p.getDuration().toMinutes();
                        int secs = (int) time % 60;
                        String m = String.format("%02d", min);
                        String s = String.format("%02d", secs);
                        TotalTime.setText(m + ":" + s);
                        SongName.setText(song.getName());
                        MusicPB.setMaximum((int) p.getDuration().toSeconds());
                        flagthread = true;
                        bm.setAvanzar(true);
                        play = false;
                    }
                });
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    public void RefreshMyWall() {
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        DefaultTableModel m = (DefaultTableModel) mywall.getModel();
        try {
            db.query.execute("select Autor,Titulo,Fecha,Likes from Publicaciones where Autor='" + USER.getUsername() + "'");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                Object[] temp = {rs.getString(3), rs.getString(1), rs.getString(2), rs.getInt(4)};
                m.addRow(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        mywall.setModel(m);
    }

    public void RefreshGeneralWall() {
        DefaultTableModel m = (DefaultTableModel) Wall.getModel();
        Dba db = new Dba("./TheSN.accdb");
        db.conectar();
        ArrayList<String> friends = new ArrayList();
        try {
            db.query.execute("select A1 from Amigos where A1='" + USER.getUsername() + "'");
            ResultSet rs = db.query.getResultSet();
            while (rs.next()) {
                friends.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (String f : friends) {
            try {
                db.query.execute("select Autor, Titulo, Likes, Fecha from Publicaciones where Autor='" + f + "'");
                ResultSet rs = db.query.getResultSet();
                while (rs.next()) {
                    Object[] temp = {rs.getString(2), rs.getString(1), rs.getString(3), rs.getInt(4)};
                    m.addRow(temp);
                }
                Wall.setModel(m);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        db.desconectar();

    }

    public static void main(String args[]) throws Exceptions, SQLException {

        Calendar Cal = new GregorianCalendar(1999, 11, 24);
        Date bday = Cal.getTime();

        // ArrayList<Usuario> Usuarios, String Nombre, int Edad, Date Bday, String Username, String PW, String RespPW, String Correo, String Pregunta, Color C) throws Exceptions {
        //METER ADMIN DONT DELETE JUST IN CASE
        BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
        BAA.loadArchive();
        Administrador A = new Administrador(new ArrayList(), "Andrea J. Mendoza", 18, bday, "andreaj", "andreA1", "Rosado", "andreaj@unitec.edu", "¿Cuál es su color favorito?", new Color(255, 204, 255));
        BAA.getUsers().add(A);
        Users = BAA.getUsers();
        BAA.overrideArchive();
        System.out.println(BAA.getUsers());

// Aqui muere lo de admin just in case
        //BinaryArchivesAdmin BAA = new BinaryArchivesAdmin("./User Information.aj");
        //BAA.loadArchive();
        //Users = BAA.getUsers();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PP().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddB;
    private javax.swing.JMenuItem AddImages;
    private javax.swing.JButton AddPics;
    private javax.swing.JButton AddPics1;
    private javax.swing.JDialog AdministrarUsuarios;
    private javax.swing.JDialog Agenda;
    private javax.swing.JDialog Album;
    private javax.swing.JList<String> AlbumList;
    private javax.swing.JTextField AlbumTitle;
    private javax.swing.JDialog AllUsersPV;
    private javax.swing.JDialog Archives;
    private javax.swing.JPopupMenu ArchivesPM;
    private javax.swing.JLabel BG;
    private com.toedter.calendar.JCalendar CalendarBday;
    private javax.swing.JDialog ChangeBG;
    private javax.swing.JButton ChangePP;
    private javax.swing.JButton CommentPost;
    private javax.swing.JDialog Console;
    private javax.swing.JTextArea ConsoleText;
    private javax.swing.JLabel ContAmigos;
    private javax.swing.JLabel ContAmigos1;
    private javax.swing.JLabel ContP;
    private javax.swing.JLabel ContP1;
    private javax.swing.JList<String> Contacts;
    private javax.swing.JTextArea Content;
    private javax.swing.JTextArea Convo;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenu Date;
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem DeleteP;
    private javax.swing.JTextArea DescAlbum;
    private javax.swing.JTextArea DescPic;
    private javax.swing.JTextArea DescPic1;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem EditText;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JMenu File;
    private javax.swing.JComboBox<String> FilterUsuarios;
    private javax.swing.JDialog FontChooser;
    private javax.swing.JMenu Help;
    private javax.swing.JDialog Home;
    private javax.swing.JButton HomeB;
    private javax.swing.JLabel Icon1;
    private javax.swing.JLabel Icon2;
    private javax.swing.JLabel Icon3;
    private javax.swing.JDialog Icons;
    private javax.swing.JDialog Images;
    private javax.swing.JButton ImportMusic;
    private javax.swing.JDialog IndPic;
    private javax.swing.JButton LikePost;
    private javax.swing.JDialog LockUser;
    private javax.swing.JFrame LogIn;
    private javax.swing.JLabel MainImage;
    private javax.swing.JToolBar MainMenu;
    private javax.swing.JTree MainTree;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JTextArea Message;
    private javax.swing.JDialog Messenger;
    private javax.swing.JProgressBar MusicPB;
    private javax.swing.JDialog MusicPlayer;
    private javax.swing.JDialog MyProfile;
    private javax.swing.JDialog Netbeans;
    private javax.swing.JDialog NewBDay;
    private javax.swing.JTextArea NewStatus;
    private javax.swing.JTextArea NewStatus1;
    private javax.swing.JDialog NewUser;
    private javax.swing.JButton NextSong;
    private javax.swing.JButton Notes;
    private javax.swing.JDialog Notifications;
    private javax.swing.JButton NotifsB;
    private javax.swing.JButton Okay;
    private javax.swing.JMenuItem Open;
    private javax.swing.JPopupMenu PMPosts;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JButton PerfilB;
    private javax.swing.JDialog PerfilPreview;
    private javax.swing.JDialog Picture;
    private javax.swing.JButton PlayPause;
    private javax.swing.JList<String> Playlist;
    private javax.swing.JPopupMenu PopUpMain;
    private javax.swing.JLabel PreviewPic;
    private javax.swing.JLabel PreviewPic1;
    private javax.swing.JButton PreviousSong;
    private javax.swing.JPopupMenu RBPM;
    private javax.swing.JDialog RecycleBin;
    private javax.swing.JTable RecycleBinTable;
    private javax.swing.JMenuItem Rename;
    private javax.swing.JMenuItem Restore;
    private javax.swing.JMenuItem Save;
    private javax.swing.JButton SaveBDay;
    private javax.swing.JMenuItem SaveDoc;
    private javax.swing.JButton SaveNewU;
    private javax.swing.JButton SendM;
    private javax.swing.JButton Share;
    private javax.swing.JButton ShareAlbum;
    private javax.swing.JButton ShareAlbum1;
    private javax.swing.JButton SharePic;
    private javax.swing.JLabel SongName;
    private javax.swing.JLabel SongName1;
    private javax.swing.JDialog Status;
    private javax.swing.JButton StopButton;
    private javax.swing.JTable TableArchives;
    private javax.swing.JDialog TextEditor;
    private javax.swing.JPopupMenu TextPM;
    private javax.swing.JLabel Time;
    private javax.swing.JTextField Title;
    private javax.swing.JLabel TotalTime;
    private javax.swing.JTree TreeArchives;
    private javax.swing.JComboBox<String> Type;
    private javax.swing.JLabel UserName;
    private javax.swing.JLabel UserName1;
    private javax.swing.JLabel UserPic;
    private javax.swing.JLabel UserPic1;
    private javax.swing.JButton UsersB;
    private javax.swing.JList<String> UsuariosLista;
    private javax.swing.JMenuItem View;
    private javax.swing.JDialog ViewAlbum;
    private javax.swing.JDialog ViewPicture;
    private javax.swing.JDialog ViewStatus;
    private javax.swing.JTable Wall;
    private javax.swing.JTable agenda;
    private javax.swing.JTextArea albmdesc;
    private javax.swing.JTextField albmt;
    private javax.swing.JButton archives;
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_login;
    private javax.swing.JButton b_shutdown;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JMenu blankspace;
    private com.toedter.calendar.JCalendar cal;
    private javax.swing.JButton calendar;
    private javax.swing.JComboBox<String> cb_question;
    private javax.swing.JLabel color;
    private javax.swing.JButton commentp;
    private javax.swing.JButton console;
    private javax.swing.JSpinner end;
    private javax.swing.JButton estcolor;
    private javax.swing.JList<String> fonts;
    private javax.swing.JMenuItem helpicons;
    private javax.swing.JButton im;
    private javax.swing.JButton images;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JButton jb_forgotpw;
    private com.toedter.calendar.JDateChooser jd_newbday;
    private javax.swing.JTextField jt_userlogin;
    private javax.swing.JButton likep;
    private javax.swing.JPasswordField lockscreenpw;
    private javax.swing.JMenu m_admin;
    private javax.swing.JMenu m_ajustes;
    private javax.swing.JMenuItem m_allusers;
    private javax.swing.JMenuItem m_bday;
    private javax.swing.JMenuItem m_changebg;
    private javax.swing.JMenuItem m_changebg1;
    private javax.swing.JMenuItem m_changecolor;
    private javax.swing.JMenuItem m_changecolor1;
    private javax.swing.JMenuItem m_email;
    private javax.swing.JMenuItem m_help;
    private javax.swing.JMenuItem m_lock;
    private javax.swing.JMenuItem m_logout;
    private javax.swing.JMenuItem m_newname;
    private javax.swing.JMenuItem m_newpw;
    private javax.swing.JMenuItem m_newun;
    private javax.swing.JMenuItem m_newuser;
    private javax.swing.JLabel mainpicv;
    private javax.swing.JLabel muestra;
    private javax.swing.JButton music;
    private javax.swing.JTable mywall;
    private javax.swing.JLabel namelockscreen;
    private javax.swing.JLabel namepost;
    private javax.swing.JButton netbeans;
    private javax.swing.JTable notifs;
    private javax.swing.JPasswordField pf_pwlogin;
    private javax.swing.JLabel pic1;
    private javax.swing.JLabel pic2;
    private javax.swing.JLabel pic3;
    private javax.swing.JLabel pic4;
    private javax.swing.JButton recycle;
    private javax.swing.JSpinner s_edad;
    private javax.swing.JButton savedate;
    private javax.swing.JButton selectpic;
    private javax.swing.JList<String> size;
    private javax.swing.JButton socials;
    private javax.swing.JSpinner start;
    private javax.swing.JList<String> style;
    private javax.swing.JButton texteditor;
    private javax.swing.JTextField tf_newuemail;
    private javax.swing.JTextField tf_newuname;
    private javax.swing.JTextField tf_newunanswer;
    private javax.swing.JPasswordField tf_newunpw;
    private javax.swing.JTextField tf_newunuser;
    private javax.swing.JTextPane txt;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
private File Sistema;
    private int cnodes = 1;
    private ArrayList<String> PathsNodes = new ArrayList();
    private String path = "./";
    private final DefaultMutableTreeNode[] TreeNodes = new DefaultMutableTreeNode[2];
    private static Administrador Admin;
    ArrayList<Image> I = new ArrayList();
    int pos1 = 0;
    int pos2 = 1;
    int pos3 = 2;
    boolean i1 = false;
    boolean i2 = false;
    boolean i3 = false;
    Image ig1;
    Image ig2;
    Image ig3;
    Image ig4;
    Image ig5;
    Image ig6;
    boolean play = true;
    ArrayList<String> MusicPaths;
    Media p;
    MediaPlayer MP;
    BarMusic bm;
    boolean flag = false;
    boolean flagthread = false;
    File Modified;
    String modifiedpath = "./";
    String modifiedpath2 = "./";
    boolean copyflag = false;
    ArrayList<String[]> Recycle;
    ArrayList<String> CodeWords = new ArrayList();
    String currentpath;
    String pathaesthetic;
    Usuario U2;
    int cbflag = 0;
    ArrayList<Actividades> As = new ArrayList();
    ArrayList<File> TempFiles = new ArrayList();
    String imagepath = "";
    ArrayList albumpaths = new ArrayList();
    Object source;
}
